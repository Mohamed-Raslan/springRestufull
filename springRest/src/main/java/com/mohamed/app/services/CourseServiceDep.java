package com.mohamed.app.services;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;

public interface CourseServiceDep {
	
	InstructorResponce addCourse(Courses courses , Integer insId);

}
