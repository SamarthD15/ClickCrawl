package com.example.reservation.service;

import com.example.reservation.model.Booking;
import com.example.reservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        updatedBooking.setId(id);
        return bookingRepository.save(updatedBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}