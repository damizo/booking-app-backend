package com.demo.bookingapp.booking

import java.time.LocalDateTime

class BookingResponseDTO(val id: Long,
                         val fromDate: LocalDateTime,
                         val toDate: LocalDateTime,
                         val hotelName: String,
                         val customerId: Long) {

}
