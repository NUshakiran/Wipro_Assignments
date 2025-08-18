package com.example.course_service.dto;

import java.time.LocalDateTime;

public class ClassroomDTO {
    private Long id;
    private Long courseId;
    private String topic;
   
    private LocalDateTime scheduleTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public LocalDateTime getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(LocalDateTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
    
    
    
}