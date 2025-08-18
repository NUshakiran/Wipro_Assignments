package com.example.billing_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billing_service.dto.MedicalRecordDto;

@FeignClient(name = "medical-records-service", url = "http://localhost:6666")
public interface MedicalRecordClient {
    @GetMapping("/medical-records/patient/{patientId}")
    List<MedicalRecordDto> getRecordsByPatient(@PathVariable("patientId") Long patientId);

}
