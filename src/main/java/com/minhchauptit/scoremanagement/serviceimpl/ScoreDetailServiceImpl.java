package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.ScoreDetail;
import com.minhchauptit.scoremanagement.repository.CustomizeScoreDetailRepository;
import com.minhchauptit.scoremanagement.repository.ScoreDetailRepository;
import com.minhchauptit.scoremanagement.service.ScoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ScoreDetailServiceImpl implements ScoreDetailService {

    @Autowired
    private ScoreDetailRepository scoreDetailRepository;

    @Autowired
    private CustomizeScoreDetailRepository customizeScoreDetailRepository;
    @Override
    public void saveScoreDetail(ScoreDetail scoreDetail) {
        scoreDetailRepository.save(scoreDetail);
    }

    @Override
    public void deleteById(Integer id) {
        scoreDetailRepository.deleteById(id);
    }

    @Override
    public List<Integer> findDistinctSemester() {
        return scoreDetailRepository.findDistinctSemester();
    }

    @Override
    public List<ScoreDetail> findScoreDetailByStudentIdAndSemester(String studentId, Integer semester) {
        return scoreDetailRepository.findScoreDetailByStudentStudentIdAndSemester(studentId,semester);
    }

    @Override
    public Boolean isExistScore(Integer subjectId, Integer semester) {
        return customizeScoreDetailRepository.isExistScore(subjectId,semester);
    }

    @Override
    @Transactional
    public void deleteBySubjectIdAndSemester(Integer subjectId, Integer semester) {
        scoreDetailRepository.deleteBySubjectIdAndSemester(subjectId,semester);
    }

    @Override
    @CacheEvict(value = "subjectUpdateNotification",allEntries = true)
    public Integer saveAll(List<ScoreDetail> list) {
        return scoreDetailRepository.saveAll(list).size();
    }
}
