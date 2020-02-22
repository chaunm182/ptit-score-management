package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Student;


import java.util.List;

public interface CustomizeStudentRepository {
    List<Student> findStudentsByStudentIdLikeOrFullNameLike(String searchInfo);
}
