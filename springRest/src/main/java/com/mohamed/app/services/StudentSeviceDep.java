package com.mohamed.app.services;

import java.util.List;

import com.mohamed.app.entity.Student;
import com.mohamed.app.response.InstructorResponce;

public interface StudentSeviceDep {
	
	InstructorResponce addStudent(Integer courseId,Student student);
	List<Student>      getStudentFromCourse(Integer courseId);
	List<Student>      getAllStudent();
	InstructorResponce deleteStudent(Integer studentId);
	InstructorResponce updateStudent(Integer studentId,Student student);

}
