package com.example.doctor_service.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_service.model.DoctorAvailability;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    List<DoctorAvailability> findByDoctorIdAndDate(Long doctorId, LocalDate date);

    List<DoctorAvailability> findByDoctorSpecializationAndDateAndIsBookedFalse(
            String specialization, LocalDate date);

    Optional<DoctorAvailability> findByDoctorIdAndDateAndTimeSlot(Long doctorId, LocalDate date, String timeSlot);


}
