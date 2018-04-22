package com.demo.bookingapp.booking

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController(value = "/api/bookings")
class BookingController(private val bookingService: BookingService) {

    @GetMapping
    fun fetchBookings(): List<BookingResponseDTO> {
        return bookingService.findBookings()
    }

    @PostMapping(value = "/{customerId}/{hotelId}")
    fun createBooking(@RequestBody bookingRequestDTO: BookingRequestDTO,
                      @PathVariable hotelId: Long,
                      @PathVariable customerId: Long): ResponseEntity<Void> {
        bookingService.create(customerId, hotelId, bookingRequestDTO)
        return ResponseEntity(HttpStatus.CREATED)
    }


}

