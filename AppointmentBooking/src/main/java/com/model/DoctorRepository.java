package com.model;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {
	
	 private Map<String, List<LocalDate>> doctorSchedule;
	 
	 public DoctorRepository() {
	        doctorSchedule = new HashMap<>();

	        List<LocalDate> doc101Schedule = new ArrayList<>();
	        doc101Schedule.add(LocalDate.of(2025, 4, 10));
	        doc101Schedule.add(LocalDate.of(2025, 4, 12));

	       
	        
	        List<LocalDate> doc202Schedule = new ArrayList<>();
	        doc202Schedule.add(LocalDate.of(2025, 5, 11));
	        doc202Schedule.add(LocalDate.of(2025, 5, 15));
	        
	        doctorSchedule.put("DOC101", doc101Schedule);
	        doctorSchedule.put("DOC202", doc202Schedule);
	    }
	 
	 
	 public Map<String, List<LocalDate>> getDoctorSchedule() {
		return doctorSchedule;
	}


	 public void setDoctorSchedule(Map<String, List<LocalDate>> doctorSchedule) {
		 this.doctorSchedule = doctorSchedule;
	 }


	 public boolean isDoctorAvailable(String doc_id, LocalDate date) {
	        List<LocalDate> availableDates = doctorSchedule.get(doc_id);
	        return availableDates != null && availableDates.contains(date);
	    }

}
