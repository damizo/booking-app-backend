package com.demo.bookingapp.booking

import java.time.LocalDateTime


data class BookingRequestDTO(var fromDate: LocalDateTime?,
                             var toDate: LocalDateTime?)
