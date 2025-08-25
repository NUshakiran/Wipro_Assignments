export interface Appointment {
  id?: number;
  patientId: number;
  doctorId: number;
  appointmentTime: string;
  status: 'SCHEDULED' | 'COMPLETED' | 'CANCELLED';
}
