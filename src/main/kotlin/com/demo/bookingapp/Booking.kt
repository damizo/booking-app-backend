package com.demo.bookingapp

import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document(collection = "BOOKINGS")
data class Booking(
        val id: Long) : Serializable
