export interface Billing {
  id?: number;
  patientId: number;
  appointmentId: number;
  amount: number;
  status: 'PENDING' | 'PAID' | 'FAILED';
  createdAt?: string // ISO Date-Time string
}
