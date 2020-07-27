package com.mohamed.app.dao;

import java.util.List;

import com.mohamed.app.entity.Instructor;
import com.mohamed.app.requests.InstrcutorRequest;
import com.mohamed.app.response.InstructorResponce;

public interface InstructorDaoDependency {
	
	InstructorResponce addInstructor(Instructor instructor);
	List<Instructor> getAllInstructors();

}
