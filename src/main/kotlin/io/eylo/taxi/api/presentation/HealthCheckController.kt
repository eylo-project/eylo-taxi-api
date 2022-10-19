package io.eylo.taxi.api.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health-check")
    fun healthCheck(): String {
        return "Eylo Taxi API Server"
    }
}
