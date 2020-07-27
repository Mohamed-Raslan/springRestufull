package com.mohamed.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.app.entity.Student;
import com.mohamed.app.response.InstructorResponce;
import com.mohamed.app.services.StudentSeviceDep;

@RestController
@RequestMapping(value = "/api")
public class StudentController {
	
	@Autowired
	@Qualifier("studentService")
	private StudentSeviceDep studentService;
	
	
	@RequestMapping(value = "/student" , method = RequestMethod.GET)
	public List<Student> getAllStudent() {
		
		return studentService.getAllStudent();
	}
	
	
	@RequestMapping(value = "/student/{courseId}" , method = RequestMethod.POST)
	public InstructorResponce addStudent(@PathVariable Integer courseId ,@RequestBody Student student) {
		
		return studentService.addStudent(courseId, student);
		
	}

	@RequestMapping(value = "/student/{courseId}" , method = RequestMethod.GET)
	public List<Student> getStudentsFromCourse(@PathVariable Integer courseId) {
		
		return studentService.getStudentFromCourse(courseId);
	}
	
	
	
	
}
