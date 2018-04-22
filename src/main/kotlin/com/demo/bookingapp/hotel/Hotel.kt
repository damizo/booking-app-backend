package com.demo.bookingapp.hotel

import com.demo.bookingapp.booking.Booking
import org.springframework.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "HOTELS")
data class Hotel(
        @Id
        val id: Long,
        val name: String,
        val address: HotelAddress,
        @OneToMany(mappedBy = "bookings")
        val bookings: MutableList<Booking> = ArrayList()
)


