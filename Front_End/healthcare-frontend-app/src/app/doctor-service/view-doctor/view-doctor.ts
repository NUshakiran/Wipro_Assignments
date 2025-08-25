import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Doctor } from '../../model/doctor';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor_service';

@Component({
  selector: 'app-view-doctor',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-doctor.html',
  styleUrls: ['./view-doctor.css']
})
export class ViewDoctor implements OnInit {

  doctors: Doctor[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private doctorService: DoctorService, private cdr: ChangeDetectorRef, private router: Router) {}

  ngOnInit(): void {
    this.loadDoctors();
  }

  loadDoctors() {
    this.doctorService.getAllDoctors().subscribe({
      next: (data) => {
        this.doctors = Array.isArray(data) ? data : [];
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch doctors.';
        console.error(err);
      }
    });
  }

  deleteDoctor(id: number | undefined) {
    if (confirm('Are you sure you want to delete this doctor?')) {
      this.doctorService.deleteDoctor(id!).subscribe({
        next: () => {
          alert('Doctor deleted successfully');
          this.loadDoctors();
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete doctor');
        }
      });
    }
  }

editDoctor(id?: number) {
    if (id) this.router.navigate(['/edit-doctor', id]);
  }
}

