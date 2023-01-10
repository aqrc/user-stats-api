package com.example.demo.handler

import com.example.demo.model.UserStats
import com.example.demo.service.storage.ClicksStorage
import com.example.demo.service.storage.ImpressionsStorage
import com.example.demo.service.storage.RequestsStorage
import java.util.*

class ApiHandler(
    private val requestsStorage: RequestsStorage,
    private val impressionsStorage: ImpressionsStorage,
    private val clicksStorage: ClicksStorage,
) {
    fun getUserStats(userId: UUID): UserStats {
        val userRequests = requestsStorage.getRequestsOfUser(userId)
        val uniqueRequestsBySessions = userRequests?.distinctBy { request -> request.sessionId }
        val clicksCount = uniqueRequestsBySessions
            ?.filter { request -> clicksStorage.hasClickInSession(request.sessionId) }
            ?.size

        val impressionsCount = uniqueRequestsBySessions
            ?.filter { request -> impressionsStorage.hasImpressionInSession(request.sessionId) }
            ?.size

        val requestWithWinningBids = userRequests?.filter { request -> request.win }

        val averageBidPrice = requestWithWinningBids
            ?.map { request -> request.bid }
            ?.average()
            ?.toFloat()

        return UserStats(
            userId = userId,
            requestsCount = userRequests?.size ?: 0,
            impressionsCount = impressionsCount ?: 0, //requestWithWinningBids?.size ?: 0,
            clicksCount = clicksCount ?: 0,
            averageBidPrice = averageBidPrice ?: 0f,
        )
    }
}