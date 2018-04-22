package com.demo.bookingapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
open class BookingAppApplication

fun main(args: Array<String>) {
    runApplication<BookingAppApplication>(*args)
}
