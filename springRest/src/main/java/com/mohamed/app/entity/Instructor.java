package com.mohamed.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="age")
	private Integer age;
	
	@JoinColumn(name = "detailId_FK")
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private InstructorDetails detailsfK;
	
	@OneToMany(mappedBy = "ins" ,fetch = FetchType.EAGER , 
			 cascade = {CascadeType.MERGE , CascadeType.REFRESH ,
				        CascadeType.DETACH, CascadeType.PERSIST})
	private List<Courses> courses;

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public InstructorDetails getDetailsfK() {
		return detailsfK;
	}

	public void setDetailsfK(InstructorDetails detailsfK) {
		this.detailsfK = detailsfK;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", detailsfK=" + detailsfK + "]";
	}
	
	
	public void addCourse(Courses course) {
		if(courses==null)
			courses = new ArrayList<Courses>();
		
		courses.add(course);
		course.setIns(this);
	}
	
	
	
	
}
