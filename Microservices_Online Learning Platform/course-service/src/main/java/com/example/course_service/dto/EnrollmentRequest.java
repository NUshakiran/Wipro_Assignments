package com.example.course_service.dto;



public class EnrollmentRequest {
    private Long courseId;
    private String studentEmail;
    
    
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
    
    

}