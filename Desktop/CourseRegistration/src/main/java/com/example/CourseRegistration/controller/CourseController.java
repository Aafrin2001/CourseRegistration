package com.example.CourseRegistration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseRegistration.model.Course;
import com.example.CourseRegistration.model.CourseRepository;

@CrossOrigin(origins = "http: //localhost:8081") //This is for Vue js
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	CourseRepository courseRepo;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(
			@RequestParam(required = false)String title){
		
		try {
			List<Course> courses = new ArrayList<Course>();
			
			if(title == null) {
				courseRepo.findAll().forEach(courses:: add);
			}else {
				courseRepo.findByTitle(title).forEach(courses::add);
				
			}
			
			
			if(courses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
