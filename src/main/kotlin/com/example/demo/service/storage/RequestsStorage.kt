package com.example.demo.service.storage

import com.example.demo.model.Request
import org.slf4j.LoggerFactory
import java.util.*

class RequestsStorage(requests: List<Request>) {
    private val logger = LoggerFactory.getLogger(RequestsStorage::class.java)

    private val userIdToRequest = hashMapOf<UUID, MutableList<Request>>()

    init {
        requests.forEach { request ->
            if (userIdToRequest.containsKey(request.userId)) {
                userIdToRequest[request.userId]!!.add(request)
            } else {
                userIdToRequest[request.userId] = mutableListOf(request)
            }
        }

        logger.info("RequestsStorage initialization completed")
    }

    fun getRequestsOfUser(userId: UUID): List<Request>? {
        return userIdToRequest[userId]
    }
}
