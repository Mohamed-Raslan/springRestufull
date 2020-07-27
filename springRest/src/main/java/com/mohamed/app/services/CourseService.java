package com.mohamed.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mohamed.app.dao.CourrseDaoDep;
import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;

@Service
public class CourseService implements CourseServiceDep {

	@Autowired
	@Qualifier("courseDao")
	private CourrseDaoDep courseservice;
	@Override
	public InstructorResponce addCourse(Courses courses, Integer insId) {
		// TODO Auto-generated method stub
		return courseservice.addCourse(courses, insId);
	}
	
	
	@Override
	public List<Courses> getCourses(Integer instructorID) {
		// TODO Auto-generated method stub
		return courseservice.getCourses(instructorID);
	}


	@Override
	public InstructorResponce deleteCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return courseservice.deleteCourse(courseId);
	}


	@Override
	public List<Courses> getAllCourses() {
		// TODO Auto-generated method stub
		return courseservice.getAllCourses();
	}

}
