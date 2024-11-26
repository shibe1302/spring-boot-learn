package com.example.mvc.demovalidation.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String>{
    private String prefixCode;

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
        boolean result ;

        if(theCode!=null){
            result=theCode.startsWith(prefixCode);
        }else{
            result=true;
        }
        return result;
    }

    @Override
    public void initialize(CourseCode thCourseCode) {

        this.prefixCode=thCourseCode.Value();

    }

    
    
}
