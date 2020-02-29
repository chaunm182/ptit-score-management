package com.minhchauptit.scoremanagement.validation.validator;

import com.minhchauptit.scoremanagement.entity.Subject;
import com.minhchauptit.scoremanagement.service.SubjectService;
import com.minhchauptit.scoremanagement.validation.annotation.SubjectCodeUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class SubjectCodeUniqueConstraintValidator implements ConstraintValidator<SubjectCodeUnique,String> {

    @Autowired
    private SubjectService subjectService;

    @Override
    public void initialize(SubjectCodeUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Subject subject = subjectService.findBySubjectId(s);
        if(subject==null) return true;
        return false;
    }
}
