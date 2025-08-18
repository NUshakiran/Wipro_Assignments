package com.example.doctor_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.model.DoctorAvailability;
import com.example.doctor_service.repository.DoctorAvailabilityRepository;
import com.example.doctor_service.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired 
	private DoctorAvailabilityRepository doc_avail_repo;
	
	public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
    
    public List<DoctorAvailability> addAvailability(Long doctorId, List<DoctorAvailability> slots) {
        Doctor doctor = getDoctor(doctorId);
        slots.forEach(slot -> slot.setDoctor(doctor));
        return doc_avail_repo.saveAll(slots);
    }

    public List<DoctorAvailability> getAvailability(Long doctorId, LocalDate date) {
        return doc_avail_repo.findByDoctorIdAndDate(doctorId, date);
    }

    public List<DoctorAvailability> findAvailableDoctors(String specialization, LocalDate date) {
        return doc_avail_repo.findByDoctorSpecializationAndDateAndIsBookedFalse(specialization, date);
    }
    
    //@Transactional
    public DoctorAvailability blockSlot(Long doctorId, LocalDate date, String timeSlot) {
        DoctorAvailability slot = doc_avail_repo.findByDoctorIdAndDateAndTimeSlot(doctorId, date, timeSlot)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        if (slot.isBooked()) {
            throw new RuntimeException("Slot already booked!");
        }
        slot.setBooked(true);
        return doc_avail_repo.save(slot);
    }

    //@Transactional
    public DoctorAvailability releaseSlot(Long doctorId, LocalDate date, String timeSlot) {
        DoctorAvailability slot = doc_avail_repo.findByDoctorIdAndDateAndTimeSlot(doctorId, date, timeSlot)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setBooked(false);
        return doc_avail_repo.save(slot);
    }
}
