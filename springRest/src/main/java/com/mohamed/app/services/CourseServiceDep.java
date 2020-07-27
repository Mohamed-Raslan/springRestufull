package com.mohamed.app.services;

import java.util.List;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;

public interface CourseServiceDep {
	
	InstructorResponce addCourse(Courses courses , Integer insId);
	List<Courses> getCourses(Integer instructorID);
	InstructorResponce deleteCourse(Integer courseId);
	List<Courses> getAllCourses();


}
