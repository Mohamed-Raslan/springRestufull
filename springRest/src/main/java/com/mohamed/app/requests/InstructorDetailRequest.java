package com.mohamed.app.requests;

import com.mohamed.app.entity.Instructor;

public class InstructorDetailRequest {

    private Integer detailiD;
	
	
	private String youtubeChannel;
	
	
	private InstrcutorRequest instructor;


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


	public InstrcutorRequest getInstructor() {
		return instructor;
	}


	public void setInstructor(InstrcutorRequest instructor) {
		this.instructor = instructor;
	}


	
	
}
