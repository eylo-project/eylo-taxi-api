package io.eylo.taxi.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EyloTaxiApiApplication

fun main(args: Array<String>) {
    runApplication<EyloTaxiApiApplication>(*args)
}
