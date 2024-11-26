package com.example.mvc.demovalidation.model;

import com.example.mvc.demovalidation.model.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
    
    private String firstName;

    @NotNull(message="is required !")
    @Size(min=1,message="is required !")
    private String lastName="";

    @Min(value=0,message="lon hon hoac bang 0")
    @Max(value=10,message="nho hon hoac bang 10")
    private int freePasses;

    @Pattern(regexp="^[a-zA-Z]{5}",message="chi dc 5 ky tu")
    private String postalCode;

    @CourseCode(Value="shibe",message="start with shibe")
    private String CourseCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
    }


    
    
    
}
