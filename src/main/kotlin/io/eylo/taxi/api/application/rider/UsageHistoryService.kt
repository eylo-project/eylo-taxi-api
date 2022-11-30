package io.eylo.taxi.api.application.rider

import io.eylo.taxi.api.domain.rider.UsageHistory
import io.eylo.taxi.api.domain.rider.UsageHistoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsageHistoryService(
    private val usageHistoryRepository: UsageHistoryRepository,
) {

    @Transactional(readOnly = true)
    fun getUsageHistories(riderId: Long): List<UsageHistory> {
        return usageHistoryRepository.findAllByRiderId(riderId)
    }
}
