package com.mohamed.app.response;

public class InstructorResponce {


	private Integer state;
	private String message;
	private long  timeStamp;
	
	
	
	public InstructorResponce() {
		super();
	}
	public InstructorResponce(Integer state, String message, long timeStamp) {
		super();
		this.state = state;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
