package com.minhchauptit.scoremanagement.validation.annotation;

import com.minhchauptit.scoremanagement.validation.validator.SubjectCodeUniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SubjectCodeUniqueConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SubjectCodeUnique {
    String value() default "";
    String message() default "Mã môn học đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
