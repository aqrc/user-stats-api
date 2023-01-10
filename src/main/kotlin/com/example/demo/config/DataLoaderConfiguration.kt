package com.example.demo.config

import com.example.demo.model.Click
import com.example.demo.model.Impression
import com.example.demo.model.Request
import com.example.demo.service.dataloader.DataLoader
import com.example.demo.service.dataloader.ClicksDataLoader
import com.example.demo.service.dataloader.ImpressionsDataLoader
import com.example.demo.service.dataloader.RequestsDataLoader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

@Configuration
class DataLoaderConfiguration {
    @Bean
    fun clicksDataLoader(resourceLoader: ResourceLoader): DataLoader<Click> {
        return ClicksDataLoader(resourceLoader)
    }

    @Bean
    fun impressionsDataLoader(resourceLoader: ResourceLoader): DataLoader<Impression> {
        return ImpressionsDataLoader(resourceLoader)
    }

    @Bean
    fun requestsDataLoader(resourceLoader: ResourceLoader): DataLoader<Request> {
        return RequestsDataLoader(resourceLoader)
    }
}