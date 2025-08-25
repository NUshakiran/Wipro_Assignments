import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { Doctor } from '../../model/doctor';
import { DoctorService } from '../doctor_service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-doctor',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-doctor.html',
  styleUrls: ['./add-doctor.css']
})
export class AddDoctor {

  doctor: Doctor = {
    name: '',
    email: '',
    specialization: '',
    contactNumber: ''
  };

  message = '';

  constructor(private doctorService: DoctorService, private router: Router) {}

  async onSubmit() {
    console.log("Submitting doctor:", this.doctor);

    this.doctorService.createDoctor(this.doctor).subscribe({
      next: (response) => {
        console.log("Doctor saved:", response);
        this.message = "Doctor added successfully!";
        // Navigate to doctor list after adding
        this.router.navigate(['/doctors']);
      },
      error: (err) => {
        console.error("Error while saving doctor:", err);
        this.message = "Error adding doctor!";
      }
    });
  }
}
