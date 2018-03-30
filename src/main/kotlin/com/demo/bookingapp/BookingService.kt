package com.demo.bookingapp

import org.springframework.stereotype.Service

@Service
class BookingService (val bookingRepository: BookingRepository){

    fun findBookings(): List<BookingDTO>{
        return listOf(BookingDTO("Ibis"));
    }
}

