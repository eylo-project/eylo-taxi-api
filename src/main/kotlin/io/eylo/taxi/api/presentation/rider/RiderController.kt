package io.eylo.taxi.api.presentation.rider

import io.eylo.taxi.api.domain.rider.Rider
import io.eylo.taxi.api.domain.rider.RiderRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RiderController(
    private val riderRepository: RiderRepository,
) {

    @PostMapping("/api/riders")
    fun createRider() {
        val rider = Rider()
        riderRepository.save(rider)
    }
}
