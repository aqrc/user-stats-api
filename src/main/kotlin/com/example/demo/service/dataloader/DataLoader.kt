package com.example.demo.service.dataloader

import org.springframework.core.io.ResourceLoader

interface DataLoader<T> {
    fun loadData(): List<T>
}

abstract class ResourceDataLoader<T>(
    private val resourcePath: String,
    private val resourceLoader: ResourceLoader
) : DataLoader<T> {

    override fun loadData(): List<T> {
        val stream = resourceLoader.getResource("classpath:$resourcePath").inputStream

        val data = mutableListOf<T>()
        stream.bufferedReader().use {
            var line = it.readLine()
            while (!line.isNullOrBlank()) {
                data.add(parseLine(line))
                line = it.readLine()
            }
        }

        return data
    }

    abstract fun parseLine(line: String): T
}