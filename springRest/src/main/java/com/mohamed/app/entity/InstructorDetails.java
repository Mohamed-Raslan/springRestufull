package com.mohamed.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detailId")
	private Integer detailiD;
	
	@Column(name = "youtubechannel")
	private String youtubeChannel;
	
	@OneToOne(mappedBy = "detailsfK" ,
			  fetch = FetchType.LAZY,
			  cascade = {CascadeType.MERGE , CascadeType.REFRESH ,
					     CascadeType.DETACH, CascadeType.PERSIST})
	private Instructor instructor;

	public Integer getDetailiD() {
		return detailiD;
	}

	public void setDetailiD(Integer detailiD) {
		this.detailiD = detailiD;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	@JsonIgnore
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails [detailiD=" + detailiD + ", youtubeChannel=" + youtubeChannel + ", instructor="
				+ instructor + "]";
	}
	
	
	
	
}
  