import { Component } from '@angular/core';
import { Billing, BillingService } from '../billing-service';
import { CommonModule, CurrencyPipe, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-generate-bill',
  standalone: true,
  imports: [CommonModule, FormsModule, CurrencyPipe, DatePipe],
  templateUrl: './generate-bill.html'
})
export class GenerateBill {
  billing: Billing = {
    id: 0,
    patientId: 0,
    appointmentId: 0,
    amount: 0,
    status: 'UNPAID',
    createdAt: new Date().toISOString()
  };

  generatedBill?: Billing;
  message = '';
  errorMessage = '';

  constructor(private readonly billingService: BillingService) {}

  onSubmit() {
    this.billingService.generateBill(
      this.billing.patientId,
      this.billing.appointmentId,
      this.billing.amount
    ).subscribe({
      next: (data) => {
        this.generatedBill = data;
        this.message = 'Bill generated successfully!';
        this.errorMessage = '';
      },
      error: (err) => {
        console.error('Error generating bill:', err);
        this.errorMessage = 'Failed to generate bill!';
        this.message = '';
      }
    });
  }
}

