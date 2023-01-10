package com.example.demo.service.dataloader

import com.example.demo.model.Impression
import org.springframework.core.io.ResourceLoader
import java.util.*

class ImpressionsDataLoader(resourceLoader: ResourceLoader) : ResourceDataLoader<Impression>(resourcePath, resourceLoader) {
    private companion object {
        const val resourcePath = "data/impressions.csv"
    }

    override fun parseLine(line: String): Impression {
        return line.split(",").let {
            Impression(
                it[0].toLong(),
                UUID.fromString(it[1]),
                it[2].toInt()
            )
        }
    }
}