package com.example.appointment_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment_service.dto.AppointmentResponseDto;
import com.example.appointment_service.dto.DoctorDto;
import com.example.appointment_service.feign.DoctorClient;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;
    @Autowired
    private DoctorClient doctorClient;

    public AppointmentResponseDto bookAppointment(Long patientId, Long doctorId, LocalDateTime time) throws Exception {
        
        boolean blocked = doctorClient.blockSlot(doctorId);
        if (!blocked) throw new Exception("Doctor slot unavailable");

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentTime(time);
        appointment.setStatus("CONFIRMED");
        Appointment saved = repository.save(appointment);

        DoctorDto doctor = doctorClient.getDoctor(doctorId);

                return new AppointmentResponseDto(saved.getId(), patientId, doctor, saved.getAppointmentTime(), saved.getStatus());
    }

    public AppointmentResponseDto getAppointmentWithDoctorDetails(Long appointmentId) throws Exception {
        Appointment appointment = repository.findById(appointmentId)
                .orElseThrow(() -> new Exception("Appointment not found"));

        DoctorDto doctor = doctorClient.getDoctor(appointment.getDoctorId());
        return new AppointmentResponseDto(appointment.getId(), appointment.getPatientId(), doctor, appointment.getAppointmentTime(), appointment.getStatus());
    }

    public void cancelAppointment(Long appointmentId) {
        repository.findById(appointmentId).ifPresent(app -> {
            app.setStatus("CANCELLED");
            repository.save(app);
            doctorClient.releaseSlot(app.getDoctorId());
        });
    }
}