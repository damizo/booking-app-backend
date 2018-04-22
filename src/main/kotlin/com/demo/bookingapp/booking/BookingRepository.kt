package com.demo.bookingapp.booking

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : JpaRepository<Booking, Long>