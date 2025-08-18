package com.example.appointment_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.appointment_service.dto.DoctorDto;

@FeignClient(name = "doctor-service", url = "http://localhost:888")
public interface DoctorClient {

	@GetMapping("/doctors/{id}")
    DoctorDto getDoctor(@PathVariable("id") Long id);

    @PostMapping("/doctors/{id}/block")
    boolean blockSlot(@PathVariable("id") Long id);

    @PostMapping("doctors/{id}/release")
    void releaseSlot(@PathVariable("id") Long id);
}