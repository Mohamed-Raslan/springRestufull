package com.mohamed.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mohamed.app.dao.StudentDaoDep;
import com.mohamed.app.entity.Student;
import com.mohamed.app.response.InstructorResponce;

@Service
public class StudentService implements StudentSeviceDep {


	@Autowired
	@Qualifier("studentDao")
	private StudentDaoDep studentDao;
	
	@Override
	public InstructorResponce addStudent(Integer courseId, Student student) {
	
		return studentDao.addStudent(courseId, student);
	}

	@Override
	public List<Student> getStudentFromCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return studentDao.getStudentFromCourse(courseId);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

	@Override
	public InstructorResponce deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public InstructorResponce updateStudent(Integer studentId, Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(studentId, student);
	}

}
