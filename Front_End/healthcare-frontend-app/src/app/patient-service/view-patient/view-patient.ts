import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { PatientService } from '../patient-service';
import { Patient } from '../../model/patient';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-patient',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './view-patient.html',
  styleUrls: ['./view-patient.css']
})
export class ViewPatient implements OnInit {

  patients: Patient[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private patientService: PatientService,
              private cdr: ChangeDetectorRef,
              private router: Router) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients() {
    console.log("Loading Patients...");
    this.patientService.getAllPatients().subscribe({
      next: (data) => {
        console.log("API Response: ", data, Array.isArray(data));
        this.patients = [];
        if (Array.isArray(data)) {
          data.forEach(p => this.patients.push(p));
          this.cdr.detectChanges();
        }
        console.log("Assigned patients length:", this.patients.length);
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch data..';
        console.error(err);
        this.isLoading = false;
      }
    });
  }

  deletePatient(id: number | undefined) {
    if (!id) return;
    if (confirm('Are you sure to delete this patient?')) {
      this.patientService.deletePatient(id).subscribe({
        next: () => {
          alert('Patient deleted successfully');
          this.loadPatients();
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete patient');
        }
      });
    }
  }

  editPatient(id: number | undefined) {
    if (!id) return;
    this.router.navigate(['/edit-patient', id]);
  }
}
