package com.mohamed.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.app.entity.Instructor;
import com.mohamed.app.requests.InstrcutorRequest;
import com.mohamed.app.response.InstructorResponce;
import com.mohamed.app.services.InstructorServiceDependency;

@RestController
@RequestMapping(value = "/api")
public class InstructorController {
	
	@Autowired
	@Qualifier("instructorService")
	private InstructorServiceDependency instructorService;
	
	@RequestMapping(value = "/instructor", method = RequestMethod.POST)
	public InstructorResponce addInstructor(@RequestBody Instructor request) {
		
		return instructorService.addInstructor(request);
		
	}
	
	@RequestMapping(value = "/instructor", method = RequestMethod.GET)
	public List<Instructor> allInstructors(){
	
		return instructorService.allInstructors();
		
	}

}
