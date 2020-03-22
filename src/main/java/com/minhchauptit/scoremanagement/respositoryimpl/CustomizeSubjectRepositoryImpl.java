package com.minhchauptit.scoremanagement.respositoryimpl;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.repository.CustomizeSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomizeSubjectRepositoryImpl implements CustomizeSubjectRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Subject> findTop3WithUpdateTime() {
        StringBuilder builder = new StringBuilder("FROM Subject s ORDER BY s.updatedAt DESC");
        Query query = entityManager.createQuery(builder.toString(),Subject.class);
        query.setMaxResults(3);
        List<Subject> result = query.getResultList();
        return result;
    }
}
