package com.example.demo.service.dataloader

import com.example.demo.model.Request
import org.springframework.core.io.ResourceLoader
import java.util.*

class RequestsDataLoader(resourceLoader: ResourceLoader) : ResourceDataLoader<Request>(resourcePath, resourceLoader) {
    private companion object {
        const val resourcePath = "data/requests.csv"
    }

    override fun parseLine(line: String): Request {
        return line.split(",").let {
            Request(
                timestamp = it[0].toLong(),
                sessionId = UUID.fromString(it[1]),
                partnerName = it[2],
                userId = UUID.fromString(it[3]),
                bid = it[4].toFloat(),
                win = it[5].toBoolean(),
            )
        }
    }
}