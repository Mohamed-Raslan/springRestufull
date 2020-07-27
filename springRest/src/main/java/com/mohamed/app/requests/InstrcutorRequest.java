package com.mohamed.app.requests;

import com.mohamed.app.entity.InstructorDetails;

public class InstrcutorRequest {

	private Integer id;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private Integer age;
	
	
	private InstructorDetails detailsfK;

	

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



	
	
}
