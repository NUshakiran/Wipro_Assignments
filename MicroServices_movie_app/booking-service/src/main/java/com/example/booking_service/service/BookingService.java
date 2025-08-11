package com.example.booking_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

 
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

       public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

   
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Optional<Booking> existingBookingOpt = bookingRepository.findById(id);
        if (existingBookingOpt.isPresent()) {
            Booking existingBooking = existingBookingOpt.get();
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setSeats(updatedBooking.getSeats());
            existingBooking.setMovieId(updatedBooking.getMovieId());
            existingBooking.setTheaterId(updatedBooking.getTheaterId());
            existingBooking.setCustomerId(updatedBooking.getCustomerId());
            return bookingRepository.save(existingBooking);
        } else {
            return null;
        }
    }

   
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
