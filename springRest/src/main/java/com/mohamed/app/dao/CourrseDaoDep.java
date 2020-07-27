package com.mohamed.app.dao;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.response.InstructorResponce;

public interface CourrseDaoDep {
	
	InstructorResponce addCourse(Courses courses,Integer instrutorId);

}
