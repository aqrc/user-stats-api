package com.example.demo.service.dataloader

import com.example.demo.model.Click
import org.springframework.core.io.ResourceLoader
import java.util.*

class ClicksDataLoader(resourceLoader: ResourceLoader) : ResourceDataLoader<Click>(resourcePath, resourceLoader) {
    private companion object {
        const val resourcePath = "data/clicks.csv"
    }

    override fun parseLine(line: String): Click {
        return line.split(",").let {
            Click(
                timestamp = it[0].toLong(),
                sessionId = UUID.fromString(it[1]),
                timePassedBeforeClick = it[2].toInt()
            )
        }
    }
}