package io.eylo.taxi.api.domain.rider

import org.springframework.data.jpa.repository.JpaRepository

interface UsageHistoryRepository : JpaRepository<UsageHistory, Long> {

    fun findAllByRiderId(riderId: Long): List<UsageHistory>
}
