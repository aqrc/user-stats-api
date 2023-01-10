package com.example.demo.service.storage

import com.example.demo.model.Click
import org.slf4j.LoggerFactory
import java.util.*

class ClicksStorage(clicks: List<Click>) {

    private val logger = LoggerFactory.getLogger(ClicksStorage::class.java)

    private val sessionIdToClick = hashMapOf<UUID, MutableList<Click>>()

    init {
        clicks.forEach { request ->
            if (sessionIdToClick.containsKey(request.sessionId)) {
                sessionIdToClick[request.sessionId]!!.add(request)
            } else {
                sessionIdToClick[request.sessionId] = mutableListOf(request)
            }
        }

        logger.info("ClicksStorage initialization completed")
    }

    fun hasClickInSession(sessionId: UUID): Boolean {
        return sessionIdToClick.containsKey(sessionId)
    }

}