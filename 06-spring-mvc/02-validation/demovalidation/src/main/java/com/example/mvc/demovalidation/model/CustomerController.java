package com.example.mvc.demovalidation.model;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {


@InitBinder
public void InitBinder(WebDataBinder webDataBinder){
    StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
    webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

}


    @GetMapping("/")
    public  String showForm(Model thModel){
        thModel.addAttribute("customer",new Customer());
        return "customer-form";
    } 
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer thCustomer,BindingResult thBindingResult){
        
        if(thBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }
        

    }
    
}
