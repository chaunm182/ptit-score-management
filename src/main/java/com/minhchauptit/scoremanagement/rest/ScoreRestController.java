package com.minhchauptit.scoremanagement.rest;

import com.minhchauptit.scoremanagement.dto.ScoreDetailDTO;
import com.minhchauptit.scoremanagement.entity.ScoreDetail;
import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.ScoreDetailService;
import com.minhchauptit.scoremanagement.service.StorageService;
import com.minhchauptit.scoremanagement.service.StudentService;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.util.bean.ScoreDetailBeanUtil;
import com.minhchauptit.scoremanagement.util.file.ExcelUtil;
import com.minhchauptit.scoremanagement.util.score.ScoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ScoreRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private StorageService storageService;

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoreDetailService scoreDetailService;



    @GetMapping("/scores")
    public String findAll(){
        return "hello";
    }

    @PostMapping("/scores")
    public String saveScoreDetail(@RequestBody ScoreDetail scoreDetail){
        scoreDetailService.saveScoreDetail(scoreDetail);
        return "Save score: "+scoreDetail.getId();
    }

    @GetMapping("/scores/{studentId},{semester}")
    public List<ScoreDetailDTO> findScoresByStudentIdAndSemester(
            @PathVariable(name = "studentId") String studentId,
            @PathVariable(name = "semester") Integer semester
    ){
        studentId = studentId.toUpperCase();
        List<ScoreDetail> scoreDetailList =  scoreDetailService.findScoreDetailByStudentIdAndSemester(studentId,semester);
        List<ScoreDetailDTO> scoreDetailDTOS = new ArrayList<>();
        for(ScoreDetail scoreDetail : scoreDetailList){
            ScoreDetailDTO scoreDetailDTO = ScoreDetailBeanUtil.entity2Dto(scoreDetail);
            ScoreUtil.setMark(scoreDetailDTO);
            ScoreUtil.setLetter(scoreDetailDTO);
            scoreDetailDTOS.add(scoreDetailDTO);
        }
        return scoreDetailDTOS;
    }

    @DeleteMapping("/scores/{id}")
    public String deleteScoreDetail(@PathVariable Integer id){
        scoreDetailService.deleteById(id);
        return "Delete success: id = "+id;
    }



    @PostMapping("/scores/upload")
    public List<ScoreDetailDTO> uploadFile(@RequestBody MultipartFile file){
        logger.info("--------Uploading file--------");
        String absolutePath = storageService.uploadFile(file);
        logger.info(absolutePath);
        logger.info("--------Upload successfully. Reading file----------");
        List<ScoreDetailDTO> result = null;
        try {
            result = excelUtil.readScoreDetailFile(absolutePath);
            int x;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/scores/upload/{subjectId},{semester}")
    public String saveScores(@PathVariable(name = "subjectId") Integer subjectId,
                             @PathVariable(name = "semester") Integer semester,
                             @RequestBody List<ScoreDetailDTO> listScoreDetailDTOS){
        Subject subject = subjectService.findById(subjectId);
        int count=0;
        for(ScoreDetailDTO scoreDetailDTO : listScoreDetailDTOS){
            ScoreDetail scoreDetail = ScoreDetailBeanUtil.dto2Entity(scoreDetailDTO);
            scoreDetail.setSubject(subject);
            scoreDetail.setSemester(semester);
            String studentId = scoreDetail.getStudent().getStudentId();
            Student student = studentService.findByStudentId(studentId);
            if(student!=null){
                scoreDetail.setStudent(student);
            }
            try {
                scoreDetailService.saveScoreDetail(scoreDetail);
                count++;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return "Success - Save "+count+" records";
    }


}
