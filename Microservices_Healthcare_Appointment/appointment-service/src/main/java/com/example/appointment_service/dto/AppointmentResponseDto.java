package com.example.appointment_service.dto;

import java.time.LocalDateTime;

public class AppointmentResponseDto {

	private Long appointmentId;
    private Long patientId;
    private DoctorDto doctor;
    private LocalDateTime appointmentTime;
    private String status;

    public AppointmentResponseDto() {}

    public AppointmentResponseDto(Long appointmentId, Long patientId, DoctorDto doctor, LocalDateTime appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctor = doctor;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}