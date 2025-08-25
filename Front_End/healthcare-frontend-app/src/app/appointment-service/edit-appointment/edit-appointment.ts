import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from '../appointment-service';
import { Appointment } from '../../model/appointment';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-appointment',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-appointment.html',
  styleUrls: ['./edit-appointment.css']
})
export class EditAppointment implements OnInit {
  appointment: Appointment = {
    patientId: 0,
    doctorId: 0,
    appointmentTime: '',
    status: 'SCHEDULED'
  };
  message = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private appointmentService: AppointmentService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.appointmentService.getAppointmentById(id).subscribe({
        next: (data) => {
          this.appointment = data;
        },
        error: (err) => {
          console.error(err);
          this.message = 'Failed to load appointment';
        }
      });
    }
  }

  updateAppointment() {
    if (!this.appointment.id) return;
    this.appointmentService.updateAppointment(this.appointment.id, this.appointment).subscribe({
      next: () => {
        alert('Appointment updated successfully');
        this.router.navigate(['/appointments']);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Failed to update appointment';
      }
    });
  }
}

