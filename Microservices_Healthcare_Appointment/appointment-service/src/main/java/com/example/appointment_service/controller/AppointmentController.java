package com.example.appointment_service.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment_service.dto.AppointmentResponseDto;
import com.example.appointment_service.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/book")
    public AppointmentResponseDto book(@RequestParam Long patientId,
                                       @RequestParam Long doctorId,
                                       @RequestParam String time) throws Exception {
        LocalDateTime appointmentTime = LocalDateTime.parse(time);
        return service.bookAppointment(patientId, doctorId, appointmentTime);
    }

    @PostMapping("/cancel/{id}")
    public void cancel(@PathVariable Long id) {
        service.cancelAppointment(id);
    }

    @GetMapping("/{id}")
    public AppointmentResponseDto get(@PathVariable Long id) throws Exception {
        return service.getAppointmentWithDoctorDetails(id);
    }
}
