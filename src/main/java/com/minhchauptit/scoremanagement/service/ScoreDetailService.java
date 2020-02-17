package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.ScoreDetail;

import java.util.List;

public interface ScoreDetailService {
    void saveScoreDetail(ScoreDetail scoreDetail);
    void deleteById(Integer id);
    List<Integer> findDistinctSemester();
    List<ScoreDetail> findScoreDetailByStudentIdAndSemester(String studentId, Integer semester);
}
