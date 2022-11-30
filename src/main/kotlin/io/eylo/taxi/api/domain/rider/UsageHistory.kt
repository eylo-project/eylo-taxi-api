package io.eylo.taxi.api.domain.rider

import io.eylo.taxi.api.domain.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "usage_history")
class UsageHistory(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val departures: String,
    val arrivals: String,
    val fare: Int,
    val riderId: Long,
) : BaseEntity()
