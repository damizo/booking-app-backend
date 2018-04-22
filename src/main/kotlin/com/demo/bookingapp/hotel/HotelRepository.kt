package com.demo.bookingapp.hotel

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : JpaRepository<Hotel, Long>
