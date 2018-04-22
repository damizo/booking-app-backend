package com.demo.bookingapp.booking

import com.demo.bookingapp.customer.Customer
import com.demo.bookingapp.hotel.Hotel
import org.springframework.data.annotation.Id
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "BOOKINGS")
data class Booking(
        @Id
        val id: Long? = null,
        val fromDate: LocalDateTime?,
        val toDate: LocalDateTime?,
        @OneToOne
        @JoinColumn(name = "CUSTOMER_ID")
        val customer: Customer,
        @OneToOne
        @JoinColumn(name = "HOTEL_ID")
        val hotel: Hotel) : Serializable

