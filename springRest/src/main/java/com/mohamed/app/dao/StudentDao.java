package com.mohamed.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.mohamed.app.entity.Courses;
import com.mohamed.app.entity.Student;
import com.mohamed.app.exceptions.StudentNotFound;
import com.mohamed.app.response.InstructorResponce;

@Transactional
@Repository
public class StudentDao implements StudentDaoDep {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public InstructorResponce addStudent(Integer courseId,Student student) {
	
		if(courseId==null)
			throw new StudentNotFound("يرجي ادخال رقم الكورس لاضافه الطلبه");
		
		Session session = sessionFactory.getCurrentSession();
		Courses course  = session.get(Courses.class, courseId);
		if(course==null)
			throw new StudentNotFound("لا يمكن اضافه الطالب عشوائيا لابد من تحديد كورس معين");
		
		course.addCoures(student);
		session.save(course);
		return new InstructorResponce(HttpStatus.ACCEPTED.value(),"تم الحفظ بنجاح",System.currentTimeMillis());

	}

	@Override
	public List<Student> getStudentFromCourse(Integer courseId) {
		
		if(courseId==null)
			throw new StudentNotFound("يرجي ادخال رقم الكورس للوصول الي الطلبه ");
		
		Session session = sessionFactory.getCurrentSession();
		Courses course  = session.get(Courses.class, courseId);
		if(course==null)
			throw new StudentNotFound("لا يمكن وجود الطلاب لابد من تحديد كورس معين");

		List<Student> allStudent = new ArrayList<Student>(course.getStudents());
		return allStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query     = session.createQuery("from Student");
		List<Student> allStudent = query.getResultList();
		return allStudent;
		
	}

	@Override
	public InstructorResponce deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		if (studentId == null)
			throw new StudentNotFound("لابد من ادخال الرقم الخاص بالطالب");

		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Student where studentId=:studentId");
		theQuery.setParameter("studentId", studentId);
	    theQuery.executeUpdate();
		return new InstructorResponce(HttpStatus.ACCEPTED.value(), "تم الحذف بنجاح", System.currentTimeMillis());

	}
	
	

}
