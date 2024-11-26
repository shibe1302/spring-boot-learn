package com.example.mvc.demovalidation.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String Value() default "Shibe";
    public String message() default "Must start with Shibe";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
