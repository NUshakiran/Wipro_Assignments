package com.example.medical_records_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medical_records_service.model.MedicalRecord;

public interface MedicalRepository extends JpaRepository<MedicalRecord, Long> {

	List<MedicalRecord> findByPatientId(Long patientId);

}
