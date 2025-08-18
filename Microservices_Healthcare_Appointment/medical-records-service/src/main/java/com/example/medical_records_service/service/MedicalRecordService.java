package com.example.medical_records_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medical_records_service.dto.AppointmentDto;
import com.example.medical_records_service.dto.PatientDto;
import com.example.medical_records_service.feign.AppointmentClient;
import com.example.medical_records_service.feign.PatientClient;
import com.example.medical_records_service.model.MedicalRecord;
import com.example.medical_records_service.repository.MedicalRepository;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRepository repository;
    
    @Autowired
    private PatientClient patientClient;
    
    @Autowired
    private AppointmentClient appoinmentClient;
    
    public MedicalRecord createRecord(MedicalRecord record) {
        return repository.save(record);
    }

    public Optional<MedicalRecord> getRecord(Long id) {
        return repository.findById(id);
    }

    public List<MedicalRecord> getRecordsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public MedicalRecord updateRecord(Long id, MedicalRecord updated) throws Exception {
        MedicalRecord record = repository.findById(id).orElseThrow(() -> new Exception("Record not found"));
        record.setDiagnosis(updated.getDiagnosis());
        record.setPrescription(updated.getPrescription());
        record.setLabResults(updated.getLabResults());
        return repository.save(record);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
    
    public String getEnrichedRecord(Long recordId) throws Exception {
        MedicalRecord record = repository.findById(recordId)
                .orElseThrow(() -> new Exception("Record not found"));

        PatientDto patient = patientClient.getPatientById(record.getPatientId());
        AppointmentDto appointment = appoinmentClient.getAppointmentById(record.getId());

        return "Record for patient: " + patient.getFirstName() +
                ", Diagnosis: " + record.getDiagnosis() +
                ", Appointment Date: " + appointment.getAppointmentDate();
    }
}
