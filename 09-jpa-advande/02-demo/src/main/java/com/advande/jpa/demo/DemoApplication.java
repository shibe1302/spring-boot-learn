package com.advande.jpa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.advande.jpa.demo.dao.appDAO;
import com.advande.jpa.demo.enity.Instructor;
import com.advande.jpa.demo.enity.InstructorDetail;



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
			//findByID(appDAO1);
			//FindInstructorDetailByID(appDAO1);
			DeleteInstructorDetailByID(appDAO1);
														};
													}
									
		private void DeleteInstructorDetailByID(appDAO appDAO1) {
			appDAO1.deleteInstructorDetail(1);

		}
			
					private void FindInstructorDetailByID(appDAO appDAO1) {
			int theID=1;
			InstructorDetail temInstructorDetail= appDAO1.FindInstructorDetailByID(theID);
			System.out.println("Temp instructor : "+ temInstructorDetail);
			System.out.println("The associate instructor "+temInstructorDetail.getInstructor());

		}
			
					private void findByID(appDAO appDAO1) {
			int theID=1;
			System.out.println("Dang tim instructor co ID : "+theID);
			Instructor tempInstructor=appDAO1.FindInstructorByID(theID);
			System.out.println("Temp instructor : "+ tempInstructor);
			System.out.println("The associate instructor detail "+tempInstructor.getInstructorDetail());
		}
			
	private void CreateInstructor(appDAO appDAo1) {
		Instructor instructor = new Instructor("Khanh", "Huyen", "KhanhHuyen132@gmail.com");
		InstructorDetail tempInstructorDetail= new InstructorDetail("https://youtu.be/7Jvgkc6VEuY?si=T6dn5lpbj3DfuMnA", "guitar");
		instructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor : "+instructor);
		appDAo1.save(instructor);
		System.out.println("Done !!!!!!!");

	}
	

}
