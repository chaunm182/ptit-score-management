package com.minhchauptit.scoremanagement.respositoryimpl;

import com.minhchauptit.scoremanagement.repository.CustomizeScoreDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class CustomizeScoreDetailRepositoryImpl implements CustomizeScoreDetailRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Boolean isExistScore(Integer subjectId, Integer semester) {
        StringBuilder stringBuilder = new StringBuilder("select 1 from ScoreDetail");
        stringBuilder.append(" where subject.id = :subjectId and semester = :semester");
        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("subjectId",subjectId);
        query.setParameter("semester",semester);
        try {
            Object result = query.getSingleResult();
        }catch (NoResultException ex){
            return false;
        }

        return true;

    }
}
