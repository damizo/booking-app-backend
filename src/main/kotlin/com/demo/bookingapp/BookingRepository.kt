package com.demo.bookingapp

import org.springframework.data.mongodb.repository.MongoRepository

interface BookingRepository : MongoRepository<Booking, Long> {

}