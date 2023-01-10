package com.example.demo.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.UUID

@JsonSerialize
data class UserStats(
    val userId: UUID,
    val requestsCount: Int,
    val impressionsCount: Int,
    val clicksCount: Int,
    val averageBidPrice: Float,
)
