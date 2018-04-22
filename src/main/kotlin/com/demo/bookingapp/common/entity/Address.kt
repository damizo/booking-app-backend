package com.demo.bookingapp.common.entity

import javax.persistence.Embeddable
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Embeddable
data class Address(
    @Id
    @GeneratedValue
    val id: Long,
    val street: String,
    val flatNumber: String,
    val houseNumber: String,
    val postalCode: String,
    val city: String,
    val country: Country
)

enum class Country {
    POLAND, ENGLAND, GERMANY
}
