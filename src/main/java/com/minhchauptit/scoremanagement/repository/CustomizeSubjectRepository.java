package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Subject;

import java.util.List;

public interface CustomizeSubjectRepository {
    List<Subject> findTop3WithUpdateTime();
}
