package com.example.demo.model

import java.util.*

data class Request(
    val timestamp: Long,
    val sessionId: UUID,
    val partnerName: String,
    val userId: UUID,
    val bid: Float,
    val win: Boolean,
)
