package com.advande.jpa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.advande.jpa.demo.dao.appDAO;
import com.advande.jpa.demo.enity.Instructor;



@SpringBootApplication
@EntityScan("com.advande.jpa.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(appDAO appDAO1){
		return runner->{
			System.out.println("  - --------------- hello -------------");
			//CreateInstructor(appDAO1);
			findByID(appDAO1);
								};
							}
			
		private void findByID(appDAO appDAO1) {
			int theID=1;
			System.out.println("Dang tim instructor co ID : "+theID);
			Instructor tempInstructor=appDAO1.FindInstructorByID(theID);
			System.out.println("Temp instructor : "+ tempInstructor);
			System.out.println("The associate instructor detail "+tempInstructor.getInstructorDetail());
		}
			
	// private void CreateInstructor(appDAO appDAo1) {
	// 	Instructor instructor = new Instructor("Trinh", "Lam", "Banhbao.beongay132@gmail.com");
	// 	InstructorDetail tempInstructorDetail= new InstructorDetail("https://youtu.be/7Jvgkc6VEuY?si=T6dn5lpbj3DfuMnA", "doge");
	// 	instructor.setInstructorDetail(tempInstructorDetail);
	// 	System.out.println("Saving instructor : "+instructor);
	// 	appDAo1.save(instructor);
	// 	System.out.println("Done !!!!!!!");

	// }
	

}
