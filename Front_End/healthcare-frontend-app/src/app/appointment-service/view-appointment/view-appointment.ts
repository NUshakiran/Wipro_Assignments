import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentService } from '../appointment-service';
import { Appointment } from '../../model/appointment';
import { Router } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-appointment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-appointment.html',
  styleUrls: ['./view-appointment.css']
})
export class ViewAppointment implements OnInit {
  appointments: Appointment[] = [];
  message = '';
  
  constructor(
    private appointmentService: AppointmentService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadAppointments();
  }

  loadAppointments() {
    this.appointmentService.getAllAppointments().subscribe({
      next: (data) => {
        this.appointments = Array.isArray(data) ? data : [];
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.message = 'Failed to load appointments';
      }
    });
  }

  deleteAppointment(id: number | undefined) {
    if (!id) return;
    if (confirm('Are you sure to delete this appointment?')) {
      this.appointmentService.deleteAppointment(id).subscribe({
        next: () => {
          alert('Appointment deleted successfully');
          this.loadAppointments();
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete appointment');
        }
      });
    }
  }

  editAppointment(id: number | undefined) {
    if (!id) return;
    this.router.navigate(['/edit-appointment', id]);
  }
}

