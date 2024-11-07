package com.example.CourseRegistration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CourseRegistration.model.Course;
import com.example.CourseRegistration.model.CourseRepository;

@SpringBootApplication
public class CourseRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CourseRepository courseRepo) {
		return args ->{
			courseRepo.save(new Course("CSIS2175" , "Advance Integrated Dev"));
			courseRepo.save(new Course("CSIS3175" , "Software Engineering"));
			courseRepo.save(new Course("CSIS1190" , "Excel For bussiness"));
			
			courseRepo.findAll().forEach(System.out::println);


		};
	}
}
