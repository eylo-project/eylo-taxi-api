package io.eylo.taxi.api.presentation.rider.dto

import io.eylo.taxi.api.domain.rider.UsageHistory
import java.time.LocalDate
import java.time.LocalDateTime

data class UsageHistoryDto(
    val date: LocalDate,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val departures: String,
    val arrivals: String,
    val fare: Int,
)

fun UsageHistory.toDto() = UsageHistoryDto(
    date = date,
    startTime = startTime,
    endTime = endTime,
    departures = departures,
    arrivals = arrivals,
    fare = fare,
)
