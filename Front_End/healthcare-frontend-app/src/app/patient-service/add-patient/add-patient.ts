import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientService } from '../patient-service';
import { Patient } from '../../model/patient';

@Component({
  selector: 'app-add-patient',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-patient.html',
  styleUrls: ['./add-patient.css']
})
export class AddPatient {

  patient: Patient = {
    name: '',
    email: '',
    contactNumber: '',
    age: 0,
    gender: 'MALE',
    insuranceNumber:' ',
    insuranceProvider:' '
  };

  message = '';

  constructor(private patientService: PatientService, private router: Router) {}

  async onSubmit() {
    console.log("Submitting patient:", this.patient);

    this.patientService.createPatient(this.patient).subscribe({
      next: (response) => {
        console.log("Patient saved:", response);
        this.message = "Patient added successfully!";
        // Navigate to patient list after adding
        this.router.navigate(['/patients']);
      },
      error: (err) => {
        console.error("Error while saving patient:", err);
        this.message = "Error adding patient!";
      }
    });
  }
}
