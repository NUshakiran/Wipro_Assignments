import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PatientService } from '../patient-service';
import { Patient } from '../../model/patient';

@Component({
  selector: 'app-edit-patient',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-patient.html',
  styleUrls: ['./edit-patient.css']
})
export class EditPatient {
  patient: Patient = { name: '', email: '', contactNumber: '', age: 0, gender: 'MALE' ,insuranceNumber: ' ',insuranceProvider:' '};
  message = '';

  constructor(
    private patientService: PatientService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    const id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(id).subscribe((data) => (this.patient = data));
  }

  async onSubmit() {
    this.patientService.updatePatient(this.patient.id!, this.patient).subscribe({
  next: () => {
    this.message = "Patient updated successfully!";
    this.router.navigate(['/patients']);
  },
  error: (err) => {
    console.error("Error updating patient:", err);
    this.message = "Error updating patient!";
  }
});
  }
}
