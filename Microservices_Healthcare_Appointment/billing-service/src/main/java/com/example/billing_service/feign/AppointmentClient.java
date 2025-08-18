package com.example.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billing_service.dto.AppointmentDto;

@FeignClient(name = "appointment-service", url = "http://localhost:7777")
public interface AppointmentClient {
    @GetMapping("/appointments/{id}")
    AppointmentDto getAppointmentById(@PathVariable("id") Long id);

}
