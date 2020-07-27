package com.mohamed.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;
import com.mohamed.app.services.CourseService;
import com.mohamed.app.services.CourseServiceDep;

@RestController
@RequestMapping(value = "/api")
public class CoursesController {
	
	@Autowired
	@Qualifier("courseService")
	private CourseServiceDep courseService;
	
	@RequestMapping(value = "/courses/{instructorId}" , method = RequestMethod.POST)
	public InstructorResponce addCourse(@PathVariable int instructorId ,@RequestBody Courses courses) {
		
		return courseService.addCourse(courses, instructorId);
		
	}

}
