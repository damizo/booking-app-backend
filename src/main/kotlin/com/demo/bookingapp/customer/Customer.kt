package com.demo.bookingapp.customer

import com.demo.bookingapp.booking.Booking
import org.springframework.data.annotation.Id
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "CUSTOMERS")
data class Customer(
        @Id
        val id: Long,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val email: String,
        @OneToMany(mappedBy = "booking", cascade = [CascadeType.ALL])
        val bookings: MutableList<Booking> = ArrayList()
)