package com.model;

import java.time.LocalDate;

public class AppointmentService {
	
	DoctorRepository docrep;

	public DoctorRepository getDocrep() {
		return docrep;
	}

	public void setDocrep(DoctorRepository docrep) {
		this.docrep = docrep;
	}
	
	public String book(String doctorId, String dateStr) {
		
        LocalDate date = LocalDate.parse(dateStr);
        
        if (docrep.isDoctorAvailable(doctorId, date)) {
            return "Appointment confirmed";
        } else {
            return "Doctor not available";
        }
    }


}
