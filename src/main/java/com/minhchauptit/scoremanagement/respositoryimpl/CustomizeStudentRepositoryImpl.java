package com.minhchauptit.scoremanagement.respositoryimpl;

import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.repository.CustomizeStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomizeStudentRepositoryImpl implements CustomizeStudentRepository {
    @Autowired
    private EntityManager entityManager;

    @Value("${student.search.limit-result}")
    private Integer limitRecord;

    @Override
    public List<Student> findStudentsByStudentIdLikeOrFullNameLike(String searchInfo) {
        List<Student> result = null;
        StringBuilder queryString = new StringBuilder("FROM Student s WHERE s.studentId LIKE :search OR");
        queryString.append(" CONCAT(s.firstName,' ',s.lastName) LIKE :search");
        Query query = entityManager.createQuery(queryString.toString(),Student.class);
        query.setParameter("search","%"+searchInfo+"%");
        query.setMaxResults(limitRecord);
        result =   query.getResultList();
        return result;
    }
}
