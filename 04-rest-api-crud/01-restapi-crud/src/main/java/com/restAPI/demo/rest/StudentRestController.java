package com.restAPI.demo.rest;


import com.restAPI.demo.enity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List <Student> theStudents;


    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Lam","Trinh"));
        theStudents.add(new Student("Lam1","Trinh1"));
        theStudents.add(new Student("Lam2","Trinh2"));

    }


    @GetMapping("/student")
    public List <Student> getStudent(){
        return theStudents;
    }

    @GetMapping("/student/lam/shiba")
    public List <Student> getStudent1(){
        return theStudents;
    }

    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        if((studentID>=theStudents.size())||(studentID<0)){
            throw new StudentNotFoundException("Student is not found : "+studentID);
        }

        return theStudents.get(studentID);
    }

}
