package io.eylo.taxi.api.domain.rider

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsageHistoryRepository : JpaRepository<UsageHistory, Long> {

    fun findAllByRiderId(riderId: Long): List<UsageHistory>
}
