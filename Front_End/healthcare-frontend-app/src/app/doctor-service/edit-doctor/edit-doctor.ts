import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Doctor } from '../../model/doctor';
import { CommonModule } from '@angular/common';
import { DoctorService } from '../doctor_service';

@Component({
  selector: 'app-edit-doctor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-doctor.html',
  styleUrls: ['./edit-doctor.css']
})
export class EditDoctor implements OnInit {
  doctor: Doctor = {
    name: '',
    email: '',
    contactNumber: '',
    specialization: ''
  };
  message = '';
  id!: number;

  constructor(private doctorService: DoctorService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.doctorService.getDoctorById(this.id).subscribe(data => this.doctor = data);
  }

  onSubmit() {
    this.doctorService.updateDoctor(this.id, this.doctor).subscribe({
      next: () => {
        this.message = 'Doctor updated successfully';
        this.router.navigate(['/doctors']);
      },
      error: () => this.message = 'Failed to update doctor'
    });
  }
}
