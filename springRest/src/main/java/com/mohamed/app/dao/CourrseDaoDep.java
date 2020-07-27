package com.mohamed.app.dao;

import java.util.List;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;

public interface CourrseDaoDep {
	
	InstructorResponce addCourse(Courses courses,Integer instrutorId);
	List<Courses> getCourses(Integer instructorId);
	InstructorResponce deleteCourse(Integer courseId);
	List<Courses> getAllCourses();
}
