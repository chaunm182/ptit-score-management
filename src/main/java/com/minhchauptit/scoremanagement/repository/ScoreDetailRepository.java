package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.ScoreDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreDetailRepository extends JpaRepository<ScoreDetail,Integer> {
    @Query(value = "SELECT DISTINCT score_detail.semester FROM ptit_score_management.score_detail", nativeQuery = true)
    List<Integer> findDistinctSemester();

    List<ScoreDetail> findScoreDetailByStudentStudentIdAndSemester(String studentId,Integer semester);

    void deleteBySubjectIdAndSemester(Integer subjectId, Integer semester);
}
