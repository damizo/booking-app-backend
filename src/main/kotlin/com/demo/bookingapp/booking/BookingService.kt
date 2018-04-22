package com.demo.bookingapp.booking

import com.demo.bookingapp.common.exception.NonRequiredDataException
import com.demo.bookingapp.common.exception.ObjectNotFound
import com.demo.bookingapp.customer.Customer
import com.demo.bookingapp.customer.CustomerRepository
import com.demo.bookingapp.hotel.Hotel
import com.demo.bookingapp.hotel.HotelRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class BookingService(private val bookingRepository: BookingRepository,
                     private val customerRepository: CustomerRepository,
                     private val hotelRepository: HotelRepository) {

    companion object {
        val log: Logger = LoggerFactory.getLogger("BookingService")
    }

    fun findBookings(): List<BookingResponseDTO> {
        return listOf(BookingResponseDTO(1L, LocalDateTime.now(),
                LocalDateTime.now(), "Ibis", 3L))
    }

    fun create(customerId: Long?,
               hotelId: Long?,
               bookingRequestDTO: BookingRequestDTO) {

        log.debug("Before validation, creating booking...")
        validate(customerId, hotelId, bookingRequestDTO)
        log.debug("Body successfully went through validation")

        val customer: Optional<Customer> = customerRepository
                .findById(customerId)

        customer.orElseThrow { throw ObjectNotFound("Customer with id $customerId not found") }
        log.debug("Customer: {}", customer)

        val hotel: Optional<Hotel> = hotelRepository
                .findById(hotelId)

        hotel.orElseThrow { throw ObjectNotFound("Hotel with id $hotelId not found") }
        log.debug("Hotel: {}", hotel)

        var booking: Booking = mapToDomain(bookingRequestDTO, customer.get(), hotel.get())
        log.debug("Booking before persist: {}", booking)
        bookingRepository.save(booking)
    }

    private fun validate(customerId: Long?, hotelId: Long?, bookingRequestDTO: BookingRequestDTO) {
        if (customerId == null) {
            throw NonRequiredDataException("Customer id cannot be null")
        }

        if (hotelId == null) {
            throw NonRequiredDataException("Hotel id cannot be null")
        }

        if (bookingRequestDTO.fromDate == null) {
            throw NonRequiredDataException("fromDate in body is required field")
        }

        if (bookingRequestDTO.toDate == null) {
            throw NonRequiredDataException("toDate in body is required field")
        }
    }

    fun mapToDomain(bookingRequestDTO: BookingRequestDTO, customer: Customer, hotel: Hotel): Booking {
        return Booking(null,
                bookingRequestDTO.fromDate,
                bookingRequestDTO.toDate,
                customer,
                hotel)
    }
}

