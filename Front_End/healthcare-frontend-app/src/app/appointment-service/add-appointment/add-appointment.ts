import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Appointment } from '../../model/appointment';
import { AppointmentService } from '../appointment-service';

@Component({
  selector: 'app-add-appointment',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-appointment.html',
  styleUrls: ['./add-appointment.css']
})
export class AddAppointment {
  appointment: Appointment = {
    patientId: 0,
    doctorId: 0,
    appointmentTime: '',
    status: 'SCHEDULED'
  };

  message = '';

  constructor(private appointmentService: AppointmentService, private router: Router) {}

  async onSubmit() {
    this.appointmentService.createAppointment(this.appointment).subscribe({
      next: () => {
        this.message = 'Appointment created successfully!';
        this.router.navigate(['/appointments']);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error creating appointment!';
      }
    });
  }
}

