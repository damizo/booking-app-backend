package com.demo.bookingapp

import com.demo.bookingapp.booking.BookingRepository
import com.demo.bookingapp.booking.BookingRequestDTO
import com.demo.bookingapp.booking.BookingService
import com.demo.bookingapp.common.exception.NonRequiredDataException
import com.demo.bookingapp.customer.CustomerRepository
import com.demo.bookingapp.hotel.HotelRepository
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime
import java.time.Month
import kotlin.reflect.KClass

//TODO: to parameterize in Spock?
//TODO: H2 database or MariaDB for tests in external docker container

@RunWith(SpringRunner::class)
class BookingServiceTest {

    @Mock
    private lateinit var bookingRepository: BookingRepository

    @Mock
    private lateinit var customerRepository: CustomerRepository

    @Mock
    private lateinit var hotelRepository: HotelRepository

    @InjectMocks
    private lateinit var bookingService: BookingService
    
    @Test(expected = NonRequiredDataException::class)
    fun shouldNotCreateBookingWithoutFromDateFieldInBody() {
        val customerId: Long = 1L
        val hotelId: Long = 15L
        var bookingRequestDTO: BookingRequestDTO = buildBookingRequest()

        bookingRequestDTO.fromDate = null

        bookingService.create(customerId, hotelId, bookingRequestDTO)
    }

    @Test(expected = NonRequiredDataException::class)
    fun shouldNotCreateBookingWithoutToDateFieldInBody() {
        var customerId: Long = 1L
        var hotelId: Long = 15L
        var bookingRequestDTO: BookingRequestDTO = buildBookingRequest()

        bookingRequestDTO.toDate = null

        bookingService.create(customerId, hotelId, bookingRequestDTO)
    }

    private fun buildBookingRequest(): BookingRequestDTO {
        return BookingRequestDTO(LocalDateTime.of(2018,
                        Month.DECEMBER,
                        15,
                        10,
                        0),
                LocalDateTime.of(2018,
                        Month.DECEMBER,
                        22,
                        10,
                        0))
    }

}