package com.mohamed.app.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private Integer studentId;
	
	@Column(name = "studentName")
	private String studentName;
	
	@Column(name="studentAge")
	private Integer studentAge;
	
	@Column(name = "studentYear")
	private String studentYear;

	public Integer getStudentId() {
		return studentId;
	}
	
	@ManyToMany(fetch = FetchType.EAGER,
			    cascade = {CascadeType.ALL})
	@JoinTable(name = "student_courses",
	           joinColumns = @JoinColumn(name = "studentIdFK"),
	           inverseJoinColumns = @JoinColumn(name = "courseIdFK"))      
	private Set<Courses> coursesList;
	


	public Set<Courses> getCoursesList() {
		return coursesList;
	}
	@JsonIgnore
	public void setCoursesList(Set<Courses> coursesList) {
		this.coursesList = coursesList;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(String studentYear) {
		this.studentYear = studentYear;
	}

	public void addCoures(Courses course) {

		if (this.coursesList == null)
			this.coursesList = new  HashSet<Courses>();
;

		this.coursesList.add(course);

	}
	
	
}
