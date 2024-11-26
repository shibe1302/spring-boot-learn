package com.advande.jpa.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.advande.jpa.demo.dao.appDAO;
import com.advande.jpa.demo.enity.Course;
import com.advande.jpa.demo.enity.Instructor;
import com.advande.jpa.demo.enity.InstructorDetail;
import com.advande.jpa.demo.enity.Review;



@SpringBootApplication
@EntityScan("com.advande.jpa.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(appDAO appDAO1){
		return runner->{

			deleteCourseandReview(appDAO1);
						//retrieveCourseAndReiviews(appDAO1);
						//System.out.println("  - --------------- hello -------------");
						//CreateCourseAndReview(appDAO1);
													};
												}
									
									
									
									
																																							
		private void deleteCourseandReview(appDAO appDAO1) {
			
		}
			
						private void retrieveCourseAndReiviews(appDAO appDAO1) {
			int theID=10;
			Course temCourse=appDAO1.findCourseAndReviewByCourseID(theID);
			System.out.println(temCourse);
			System.out.println(temCourse.getReviews());
			System.out.println(" ----- Done ! -----");
		}
			
					private void CreateCourseAndReview(appDAO appDAO1) {
			Course tempCourse=new Course("Khoa hoc danh cho nguoi bi yeu sinh ly");

			tempCourse.addReview(new Review("khoa hoc tuyet voi vai lon !"));
			tempCourse.addReview(new Review("Dit con me tren ca tuyet voi !"));
			tempCourse.addReview(new Review("Deo the tin duoc toi quay tay nhieu hon sau khi hoc !"));
			tempCourse.addReview(new Review("CHim cua toi tu 9cm dai len 15cm sau khi hoc !"));

			appDAO1.saveCourse(tempCourse);
			System.out.println(" ----- Done ! -----");

		}
			
						private void deleteCourse(appDAO appDAO1) {
				int theID=10;
				appDAO1.deleteCourseByID(theID);
			}
			
						private void deleteInstructor(appDAO appDAO1) {
				int theID=1;
				appDAO1.deleteInstructorByID(theID);
				System.out.println(" ----- Done ! -----");

			}
			
					private void updateInstructor(appDAO appDAO1) {
			int theID=1;
			Instructor  instructor =appDAO1.FindInstructorByID(theID);
			instructor.setLastName("Cai dcmmmmmmmmmm");
			appDAO1.updateInstructor(instructor);
			System.out.println(" ----- Done ! -----");
		}
			
				private void findInstructorByIDJoinFetch(appDAO appDAO1) {
		int theID=1;
		System.out.println("Dang tim instructor co ID : "+theID);
		Instructor teInstructor=appDAO1.findInstructorByIDJoinFetch(theID);
		System.out.println("Temp instructor : "+ teInstructor);
		System.out.println("The associate course : "+ teInstructor.getCourses());
		System.out.println(" ----- Done ! -----");

	}
			
				private void findCourseForInstructor(appDAO appDAO1) {
			int theID=1;
			System.out.println("Dang tim instructor co ID : "+theID);
			Instructor tempInstructor=appDAO1.FindInstructorByID(theID);
			System.out.println("Temp instructor : "+ tempInstructor);
			List<Course> tempCourse=appDAO1.listCourseByID(theID);
			tempInstructor.setCourses(tempCourse);
			System.out.println("The associate course : "+ tempInstructor.getCourses());

		
	}
			
					private void findInstuctorWithCourse(appDAO appDAO1) {
			int theID=1;
			Instructor tempInstructor=appDAO1.FindInstructorByID(theID);
			System.out.println("the assoicated course : "+tempInstructor.getCourses());
			System.out.println(" ----- Done ! -----");


		}
			
		private void createInstructorWithCourse(appDAO appDAO1) {

		Instructor instructor = new Instructor("Trinh Van", "A", "TrinhvanA@gmail.com");
		InstructorDetail tempInstructorDetail= new InstructorDetail("https://youtu.be/7Jvgkc6VEuY?si=T6dn5lpbj3DfuMnA", "drumb");
		instructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1=new Course("Huong dan quay tay tai nha");
		Course tempCourse2=new Course("Huong dan cac tu the cuc khoai");
		 instructor.add(tempCourse1);
		 instructor.add(tempCourse2);

		 System.out.println("The courses : "+instructor.getCourses());
		 appDAO1.save(instructor);
		 System.out.println(" ----- Done ! -----");
		
			
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
