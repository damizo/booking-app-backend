package com.demo.bookingapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class BookingApplication

fun main(args: Array<String>) {
    runApplication<BookingApplication>(*args)
}