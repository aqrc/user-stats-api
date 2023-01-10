package com.example.demo.service.storage

import com.example.demo.model.Impression
import org.slf4j.LoggerFactory
import java.util.*

class ImpressionsStorage(impressions: List<Impression>) {

    private val logger = LoggerFactory.getLogger(ImpressionsStorage::class.java)

    private val sessionIdToImpression = hashMapOf<UUID, MutableList<Impression>>()

    init {
        impressions.forEach { request ->
            if (sessionIdToImpression.containsKey(request.sessionId)) {
                sessionIdToImpression[request.sessionId]!!.add(request)
            } else {
                sessionIdToImpression[request.sessionId] = mutableListOf(request)
            }
        }

        logger.info("ImpressionsStorage initialization completed")
    }

    fun hasImpressionInSession(sessionId: UUID): Boolean {
        return sessionIdToImpression.containsKey(sessionId)
    }
}