package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.repository.CustomizeSubjectRepository;
import com.minhchauptit.scoremanagement.repository.SubjectRepository;
import com.minhchauptit.scoremanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CustomizeSubjectRepository customizeSubjectRepository;
    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Page<Subject> findAllWithPagingAndSorting(Integer page, Integer size, String sortExpression, String sortDirection) {
        Sort sort = Sort.by(sortExpression);
        if(sortDirection.equalsIgnoreCase("ASC")) sort.ascending();
        else if(sortDirection.equalsIgnoreCase("DESC")) sort.descending();

        Pageable pageable = PageRequest.of(page,size,sort);
        return subjectRepository.findAll(pageable);
    }

    @Override
    public Subject save(Subject subject) {
        long currentTime = System.currentTimeMillis();
        subject.setCreatedAt(new Timestamp(currentTime));
        subject.setUpdatedAt(new Timestamp(currentTime));
        return subjectRepository.save(subject);
    }

    @Override
    public Subject findById(Integer id) {
        Optional<Subject> optional = subjectRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    @Override
    public long calculateTotalPages(Integer size) {
        long totalRecord = subjectRepository.count();
        if (totalRecord%size==0) return totalRecord/size;
        return totalRecord/size +1;
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject findBySubjectId(String subjectId) {
        Optional<Subject> subjectOptional = subjectRepository.findBySubjectId(subjectId);
        if(subjectOptional.isPresent()) return subjectOptional.get();
        return null;
    }

    @Override
    public List<Subject> findTop3WithUpdateTime() {
        return customizeSubjectRepository.findTop3WithUpdateTime();
    }
}
