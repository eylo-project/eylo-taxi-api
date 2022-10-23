package io.eylo.taxi.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaxiApiApplication

fun main(args: Array<String>) {
    runApplication<TaxiApiApplication>(*args)
}
