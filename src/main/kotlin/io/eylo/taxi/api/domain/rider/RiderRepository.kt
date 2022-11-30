package io.eylo.taxi.api.domain.rider

import org.springframework.data.jpa.repository.JpaRepository

interface RiderRepository : JpaRepository<Rider, Long>
