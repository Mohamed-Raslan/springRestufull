package com.mohamed.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseId")
	private Integer courseId;
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "time")
	private String time;
	
	@JoinColumn(name = "instructorFK")
	@ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH,CascadeType.MERGE,
		                                         CascadeType.REFRESH})

	private Instructor ins;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@JsonIgnore
	public Instructor getIns() {
		return ins;
	}

	public void setIns(Instructor ins) {
		this.ins = ins;
	}

	

	
	
	
	
}
    