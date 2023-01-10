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
                it[0].toLong(),
                UUID.fromString(it[1]),
                it[2],
                UUID.fromString(it[3]),
                it[4].toFloat(),
                it[5].toBoolean()
            )
        }
    }
}