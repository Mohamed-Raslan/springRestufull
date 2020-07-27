package com.mohamed.app.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.mohamed.app.entity.Instructor;
import com.mohamed.app.exceptions.StudentNotFound;
import com.mohamed.app.response.InstructorResponce;

@Repository
@Transactional
public class InstructorDao implements InstructorDaoDependency {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public InstructorResponce addInstructor(Instructor instructor) {
		Session session = sessionFactory.getCurrentSession();
		if(instructor.getId()!=null) {
			Instructor in   = session.get(Instructor.class, instructor.getId());
			if(in==null)
				throw new StudentNotFound("المعيد غير موجود بالفعل");
			
			session.merge(instructor);
			return new InstructorResponce(HttpStatus.ACCEPTED.value(),"تم التعديل بنجاح",System.currentTimeMillis());
		}
		session.saveOrUpdate(instructor);
		return new InstructorResponce(HttpStatus.ACCEPTED.value(),"تم الحفظ بنجاح",System.currentTimeMillis());
	}

	@Override
	public List<Instructor> getAllInstructors() {
		Session session = sessionFactory.getCurrentSession();
		List<Instructor> Instructor  = (List<Instructor>) session.createQuery("from Instructor").list();
		return Instructor;
	}
	
	
	
	

}
