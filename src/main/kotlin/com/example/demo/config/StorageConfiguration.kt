package com.example.demo.config

import com.example.demo.model.Click
import com.example.demo.model.Impression
import com.example.demo.model.Request
import com.example.demo.service.dataloader.DataLoader
import com.example.demo.service.storage.ClicksStorage
import com.example.demo.service.storage.ImpressionsStorage
import com.example.demo.service.storage.RequestsStorage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StorageConfiguration {
    @Bean
    fun requestsStorage(dataLoader: DataLoader<Request>): RequestsStorage {
        return RequestsStorage(dataLoader.loadData())
    }

    @Bean
    fun impressionsStorage(dataLoader: DataLoader<Impression>): ImpressionsStorage {
        return ImpressionsStorage(dataLoader.loadData())
    }

    @Bean
    fun clicksStorage(dataLoader: DataLoader<Click>): ClicksStorage {
        return ClicksStorage(dataLoader.loadData())
    }
}