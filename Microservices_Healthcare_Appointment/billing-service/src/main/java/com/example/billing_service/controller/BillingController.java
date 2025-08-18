package com.example.billing_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billing_service.dto.AppointmentDto;
import com.example.billing_service.dto.BillingDto;
import com.example.billing_service.dto.PatientAppointmentBillingDto;
import com.example.billing_service.dto.PatientDto;
import com.example.billing_service.feign.AppointmentClient;
import com.example.billing_service.feign.PatientClient;
import com.example.billing_service.model.Billing;
import com.example.billing_service.service.BillingService;

@RestController
@RequestMapping("/api/billings")

public class BillingController {
	
	@Autowired
    private BillingService billingService;
	
	@Autowired
	private PatientClient patientClient;
	
	@Autowired
	private AppointmentClient appointmentClient;

	@PostMapping("/generate/{patientId}/{appointmentId}")
	public ResponseEntity<PatientAppointmentBillingDto> generateBill(
	        @PathVariable Long patientId,
	        @PathVariable Long appointmentId) {

	   
	    Billing bill = billingService.generateBill(patientId, appointmentId);

	   
	    PatientDto patient = patientClient.getPatientById(patientId);
	    AppointmentDto appointment = appointmentClient.getAppointmentById(appointmentId);

	   
	    PatientAppointmentBillingDto response = new PatientAppointmentBillingDto(
	            patient,
	            appointment,
	            mapBillingToDto(bill)
	    );

	    return ResponseEntity.ok(response);
	}

	private BillingDto mapBillingToDto(Billing bill) {
	    BillingDto dto = new BillingDto();
	    dto.setId(bill.getId());
	    dto.setPatientId(bill.getPatientId());
	    dto.setAppointmentId(bill.getAppointmentId());
	    dto.setAmount(bill.getAmount());
	    dto.setStatus(bill.getStatus());
	    dto.setCreatedAt(bill.getCreatedAt());
	    return dto;
	}


    @PutMapping("/pay/{billId}")
    public ResponseEntity<Billing> payBill(@PathVariable Long billId) {
        return ResponseEntity.ok(billingService.payBill(billId));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Billing>> getBillsForPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(billingService.getBillsForPatient(patientId));
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Billing> getBillById(@PathVariable Long billId) {
        return ResponseEntity.ok(billingService.getBillById(billId));
    }

}
