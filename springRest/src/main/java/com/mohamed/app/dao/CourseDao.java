package com.mohamed.app.dao;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Courses> getCourses(Integer instructorId) {
		
		if(instructorId ==null) 
			throw new StudentNotFound("رجاء ادخال الرقم الخاص بالمعيد حتي نتمكن من جلب الكورسات");
			
			Session session = sessionFactory.getCurrentSession();
			Instructor instructor = session.get(Instructor.class, instructorId);
			if(instructor==null)
				throw new StudentNotFound("لا يوجد معيد لذلك لا يوجد كورسات");
			List<Courses> targetList = new ArrayList<>(instructor.getCourses());
//			List<Courses> courses = (List<Courses>) instructor.getCourses();
			return targetList;	
	
	}

	@Override
	public InstructorResponce deleteCourse( Integer courseId) {
		
		if(courseId==null) 
			throw new StudentNotFound("رجاء ادخال الرقم الخاص بالكورس");
			
		Session session       = sessionFactory.getCurrentSession();
		Courses courses       = session.get(Courses.class, courseId);
		if(courses==null)
			throw new StudentNotFound("هذا الكورس غير متوااجد بالفعل!");
		
		session.delete(courses);
		return new InstructorResponce(HttpStatus.ACCEPTED.value(),"تمت حذف الكورس بنجاح",System.currentTimeMillis());
	}

	@Override
	public List<Courses> getAllCourses() {
		
		Session session       = sessionFactory.getCurrentSession();
		List<Courses> courses  = (List<Courses>) session.createQuery("from Courses").list();
		return courses;
		
	}

}
