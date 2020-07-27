package com.mohamed.app.services;

import java.util.List;

import com.mohamed.app.entity.Instructor;
import com.mohamed.app.requests.InstrcutorRequest;
import com.mohamed.app.response.InstructorResponce;

public interface InstructorServiceDependency {
	
	InstructorResponce addInstructor(Instructor request);
	List<Instructor> allInstructors();

}
