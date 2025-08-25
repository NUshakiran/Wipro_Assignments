import { Component, OnInit } from '@angular/core';
import { Billing, BillingService } from '../billing-service';
import { CommonModule, CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-view-billings',
  standalone: true,
  imports: [CommonModule, CurrencyPipe, DatePipe],
  templateUrl: './view-billing.html'
})
export class ViewBillings implements OnInit {
  billings: Billing[] = [];
  message = '';
  errorMessage = '';

  constructor(private billingService: BillingService) {}

  ngOnInit(): void {
    this.loadBillings();
  }

  loadBillings(): void {
    this.billingService.getAllBillings().subscribe({
      next: (data) => {
        this.billings = data;
      },
      error: (err) => {
        console.error('Failed to fetch billings', err);
        this.errorMessage = 'Failed to load bills!';
      }
    });
  }

  payBill(billId: number): void {
    this.billingService.payBill(billId).subscribe({
      next: () => {
        this.message = 'Payment successful!';
        this.errorMessage = '';
        this.loadBillings();
      },
      error: (err) => {
        console.error('Failed to pay bill', err);
        this.errorMessage = 'Payment failed!';
        this.message = '';
      }
    });
  }
}
