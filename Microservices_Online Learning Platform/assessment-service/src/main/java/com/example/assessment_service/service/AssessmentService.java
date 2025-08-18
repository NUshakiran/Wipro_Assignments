package com.example.assessment_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.repository.AssessmentRepository;

@Service
public class AssessmentService {
	
	@Autowired
	private AssessmentRepository assessmentRepository;
	
	  public Assessment createAssessment(Assessment assessment) {
	        return assessmentRepository.save(assessment);
	    }

	    public List<Assessment> getAllAssessments() {
	        return assessmentRepository.findAll();
	    }

	    public Assessment getAssessmentById(Long id) {
	        return assessmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assessment not found"));
	    }

	    public void deleteAssessment(Long id) {
	        assessmentRepository.deleteById(id);
	    }
}
