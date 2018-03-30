package com.demo.bookingapp

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/api/bookings")
class BookingController(val bookingService: BookingService) {


    @GetMapping
    fun fetchBookings() : List<BookingDTO> {
        return bookingService.findBookings()
    }


}

