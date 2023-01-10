package com.example.demo.model

import java.util.*

data class Impression(
    val timestamp: Long,
    val sessionId: UUID,
    val duration: Int,
)