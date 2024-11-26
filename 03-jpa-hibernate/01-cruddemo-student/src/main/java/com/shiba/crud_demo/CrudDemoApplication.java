package com.shiba.crud_demo;

import com.shiba.crud_demo.dao.StudentDAO;
import com.shiba.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempstudent= new Student("lam","trinh","banhbaobeongay");
		studentDAO.save(tempstudent);
		System.out.println("ID : "+tempstudent.getId());
	}
}
