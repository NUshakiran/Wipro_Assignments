

package com.example.doctor_service.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.model.DoctorAvailability;
import com.example.doctor_service.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getBySpecialization(@RequestParam String specialization) {
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialization(specialization));
    }

   
    @PostMapping("/{id}/availability")
    public ResponseEntity<List<DoctorAvailability>> addAvailability(@PathVariable Long id,
                                                                    @RequestBody List<DoctorAvailability> slots) {
        return ResponseEntity.ok(doctorService.addAvailability(id, slots));
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<List<DoctorAvailability>> getAvailability(@PathVariable Long id,
                                                                    @RequestParam String date) {
        return ResponseEntity.ok(doctorService.getAvailability(id, LocalDate.parse(date)));
    }

    @GetMapping("/available")
    public ResponseEntity<List<DoctorAvailability>> getAvailableDoctors(@RequestParam String specialization,
                                                                        @RequestParam String date) {
        return ResponseEntity.ok(doctorService.findAvailableDoctors(specialization, LocalDate.parse(date)));
    }
    
    @PostMapping("/{id}/block-slot")
    public ResponseEntity<DoctorAvailability> blockSlot(@PathVariable Long id,
                                                        @RequestBody Map<String, String> request) {
        return ResponseEntity.ok(doctorService.blockSlot(id,
                LocalDate.parse(request.get("date")),
                request.get("timeSlot")));
    }

    @PostMapping("/{id}/release-slot")
    public ResponseEntity<DoctorAvailability> releaseSlot(@PathVariable Long id,
                                                          @RequestBody Map<String, String> request) {
        return ResponseEntity.ok(doctorService.releaseSlot(id,
                LocalDate.parse(request.get("date")),
                request.get("timeSlot")));
    }
       
}
