package com.example.billing_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.billing_service.model.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long>{
	
	List<Billing> findByPatientId(Long patientId);

}
