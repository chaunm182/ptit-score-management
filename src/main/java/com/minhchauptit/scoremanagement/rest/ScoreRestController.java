package com.minhchauptit.scoremanagement.rest;

import com.minhchauptit.scoremanagement.dto.ScoreDetailDTO;
import com.minhchauptit.scoremanagement.dto.Transcript;
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
import constant.SaveScoreAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
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

    @GetMapping("/scores/transcript/{studentId},{semester}")
    public Transcript getTranscriptByStudentIdAndSemester(
            @PathVariable(name = "studentId") String studentId,
            @PathVariable(name = "semester") Integer semester,
            HttpServletRequest request
    ){
        Transcript transcript = new Transcript();
        studentId = studentId.toUpperCase();
        List<ScoreDetail> scoreDetailList =  scoreDetailService.findScoreDetailByStudentIdAndSemester(studentId,semester);
        List<ScoreDetailDTO> scoreDetailDTOS = new ArrayList<>();
        float termPointAverage = (float) 0.0;
        int credits = 0;
        for(ScoreDetail scoreDetail : scoreDetailList){
            ScoreDetailDTO scoreDetailDTO = ScoreDetailBeanUtil.entity2Dto(scoreDetail);
            ScoreUtil.setMark(scoreDetailDTO);
            ScoreUtil.setLetter(scoreDetailDTO);
            scoreDetailDTOS.add(scoreDetailDTO);
            float point4 = ScoreUtil.convertLetterToPoint4(scoreDetailDTO.getLetter());
            int credit = scoreDetailDTO.getSubjectDTO().getCredit();
            termPointAverage+=(point4*credit);
            credits+=credit;
        }
        termPointAverage = termPointAverage/credits;
        //round
        termPointAverage = termPointAverage*100;
        termPointAverage = Math.round(termPointAverage);
        termPointAverage/=100;
        //set props
        transcript.setListScore(scoreDetailDTOS);
        transcript.setTermPointAverage(termPointAverage);
        return transcript;

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

    @PostMapping("/scores/upload/{subjectId},{semester},{action}")
    public String saveScores(@PathVariable(name = "subjectId") Integer subjectId,
                             @PathVariable(name = "semester") Integer semester,
                             @PathVariable(name = "action") Integer action,
                             @RequestBody List<ScoreDetailDTO> listScoreDetailDTOS){
        StringBuilder response = new StringBuilder();
        if (action == SaveScoreAction.DELETE_AND_SAVE_NEW_RECORDS) {
            scoreDetailService.deleteBySubjectIdAndSemester(subjectId, semester);
            response.append("Deleted old records and ");
        }
        //update time
        Subject subject = subjectService.findById(subjectId);
        subject.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        subjectService.save(subject);
        //save new record
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
                logger.info("====> Saved score successfully - count: "+count);
            }catch (Exception ex){
                logger.warning(ex.getMessage());
                logger.warning("save failed student: "+studentId);
            }
        }
        response.append("Saved "+count+" new records");
        //end of save

        return response.toString();
    }

    @GetMapping("/scores/check/{subjectId},{semester}")
    public String isExistScore(@PathVariable("subjectId") Integer id,
                                @PathVariable("semester") Integer semester){
        return String.valueOf(scoreDetailService.isExistScore(id,semester));

    }


}
