package com.mohamed.app.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.entity.Instructor;
import com.mohamed.app.exceptions.StudentNotFound;
import com.mohamed.app.response.InstructorResponce;

@Repository
@Transactional
public class CourseDao implements CourrseDaoDep {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public InstructorResponce addCourse(Courses courses, Integer instrutorId) {
		
		Session session = sessionFactory.getCurrentSession();
		// retreve Instructor 
		Instructor instructor = session.get(Instructor.class, instrutorId);
		if(instructor==null)
			throw new StudentNotFound("لا يوجد معيد لاضافه هذا الكورس له");
		
		instructor.addCourse(courses);
		session.saveOrUpdate(courses);
		return new InstructorResponce(HttpStatus.ACCEPTED.value(),"تمت اضافه الكورس",System.currentTimeMillis());
	}

}
