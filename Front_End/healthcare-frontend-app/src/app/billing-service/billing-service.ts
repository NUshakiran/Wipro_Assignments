
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Billing {
  id: number;
  patientId: number;
  appointmentId: number;
  amount: number;
  status: string;
  createdAt: string;
}

@Injectable({
  providedIn: 'root'
})
export class BillingService {
  private readonly baseUrl = 'http://localhost:8082/api/billings';

  constructor(private readonly http: HttpClient) {}


  getAllBillings(): Observable<Billing[]> {
    return this.http.get<Billing[]>(`${this.baseUrl}`);
  }


  getBillingById(id: number): Observable<Billing> {
    return this.http.get<Billing>(`${this.baseUrl}/${id}`);
  }


  generateBill(patientId: number, appointmentId: number, amount: number): Observable<Billing> {
    return this.http.post<Billing>(`${this.baseUrl}/generate`, {
      patientId,
      appointmentId,
      amount
    });
  }

  payBill(billId: number): Observable<Billing> {
    return this.http.put<Billing>(`${this.baseUrl}/pay/${billId}`, {});
  }

  getBillsForPatient(patientId: number): Observable<Billing[]> {
    return this.http.get<Billing[]>(`${this.baseUrl}/patient/${patientId}`);
  }
}
