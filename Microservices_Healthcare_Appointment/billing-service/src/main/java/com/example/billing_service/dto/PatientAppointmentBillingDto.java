package com.example.billing_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PatientAppointmentBillingDto {
    private PatientDto patient;
    private AppointmentDto appointment;
    private BillingDto billing;
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	public AppointmentDto getAppointment() {
		return appointment;
	}
	public void setAppointment(AppointmentDto appointment) {
		this.appointment = appointment;
	}
	public BillingDto getBilling() {
		return billing;
	}
	public void setBilling(BillingDto billing) {
		this.billing = billing;
	}
	public PatientAppointmentBillingDto(PatientDto patient, AppointmentDto appointment, BillingDto billing) {
		super();
		this.patient = patient;
		this.appointment = appointment;
		this.billing = billing;
	}
    
    
    
 
    
     
}
