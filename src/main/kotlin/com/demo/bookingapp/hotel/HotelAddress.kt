package com.demo.bookingapp.hotel

import com.demo.bookingapp.common.entity.Address
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "HOTEL_ADDRESSES")
data class HotelAddress(
        @Embedded
        val address: Address
)