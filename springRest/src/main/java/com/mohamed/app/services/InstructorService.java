package com.mohamed.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mohamed.app.dao.InstructorDaoDependency;
import com.mohamed.app.entity.Instructor;
import com.mohamed.app.requests.InstrcutorRequest;
import com.mohamed.app.response.InstructorResponce;

@Service
public class InstructorService implements InstructorServiceDependency {

	@Autowired
	@Qualifier("instructorDao")
	private InstructorDaoDependency instructorDao;
	
	@Override
	public InstructorResponce addInstructor(Instructor request) {
		
		return instructorDao.addInstructor(request);
	}

	@Override
	public List<Instructor> allInstructors() {
		
		return instructorDao.getAllInstructors();
	}

}
