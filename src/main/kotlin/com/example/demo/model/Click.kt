package com.example.demo.model

import java.util.UUID

data class Click(
    val timestamp: Long,
    val sessionId: UUID,
    val timePassedBeforeClick: Int
)
