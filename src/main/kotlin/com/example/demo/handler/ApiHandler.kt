package com.example.demo.handler

import com.example.demo.model.UserStats
import java.util.*

class ApiHandler {
    fun getUserStats(userId: UUID): UserStats {
        return UserStats(
            userId, 1, 2, 3, 4.3f,
        )
    }
}