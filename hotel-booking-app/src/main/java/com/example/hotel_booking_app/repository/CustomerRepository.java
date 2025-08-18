package com.example.hotel_booking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel_booking_app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}