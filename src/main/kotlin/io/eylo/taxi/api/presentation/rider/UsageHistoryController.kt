package io.eylo.taxi.api.presentation.rider

import io.eylo.taxi.api.application.rider.UsageHistoryService
import io.eylo.taxi.api.presentation.ApiResponse
import io.eylo.taxi.api.presentation.ApiResponse.Companion.OK
import io.eylo.taxi.api.presentation.rider.dto.UsageHistoryDto
import io.eylo.taxi.api.presentation.rider.dto.toDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsageHistoryController(
    private val usageHistoryService: UsageHistoryService,
) {

    @GetMapping("/api/usage-histories")
    fun getUsageHistories(
        @RequestParam riderId: Long,
    ): ApiResponse<List<UsageHistoryDto>> {
        val usageHistories = usageHistoryService.getUsageHistories(riderId)
        return OK(usageHistories.map { it.toDto() })
    }
}
