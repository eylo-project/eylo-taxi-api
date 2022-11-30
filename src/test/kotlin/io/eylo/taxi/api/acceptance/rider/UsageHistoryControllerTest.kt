package io.eylo.taxi.api.acceptance.rider

import com.fasterxml.jackson.core.type.TypeReference
import io.eylo.taxi.api.acceptance.AcceptanceTest
import io.eylo.taxi.api.domain.rider.UsageHistory
import io.eylo.taxi.api.domain.rider.UsageHistoryRepository
import io.eylo.taxi.api.presentation.ApiResponse
import io.eylo.taxi.api.presentation.rider.dto.UsageHistoryDto
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime

internal class UsageHistoryControllerTest(
    private val usageHistoryRepository: UsageHistoryRepository,
) : AcceptanceTest() {

    @AfterEach
    fun afterAll() {
        usageHistoryRepository.deleteAll()
    }

    @Test
    fun `택시 이용 내역을 조회한다`() {
        // given
        val startTime = LocalDateTime.now()
        val endTime = LocalDateTime.now().plusHours(1)
        val departures = "집"
        val arrivals = "카페"
        val fare = 4000

        val usageHistory = UsageHistory(
            startTime = startTime,
            endTime = endTime,
            departures = departures,
            arrivals = arrivals,
            fare = fare,
            riderId = 1,
        )

        usageHistoryRepository.save(usageHistory)

        // when
        val response = objectMapper.readValue(
            this.mockMvc.perform(MockMvcRequestBuilders.get("/api/usage-histories?riderId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcRestDocumentation.document("usage-history-get-api"))
                .andReturn()
                .response
                .getContentAsString(StandardCharsets.UTF_8),
            object : TypeReference<ApiResponse<List<UsageHistoryDto>>>() {}
        )

        // then
        assertAll(
            { assertEquals(response.data.first().startTime, startTime) },
            { assertEquals(response.data.first().endTime, endTime) },
            { assertEquals(response.data.first().departures, departures) },
            { assertEquals(response.data.first().arrivals, arrivals) },
            { assertEquals(response.data.first().fare, fare) },
        )
    }
}
