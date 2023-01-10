package com.example.demo.config

import com.example.demo.handler.ApiHandler
import com.example.demo.service.storage.ClicksStorage
import com.example.demo.service.storage.ImpressionsStorage
import com.example.demo.service.storage.RequestsStorage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HandlerConfiguration {
    @Bean
    fun apiHandler(
        requestsStorage: RequestsStorage,
        impressionsStorage: ImpressionsStorage,
        clicksStorage: ClicksStorage,
    ): ApiHandler {
        return ApiHandler(
            requestsStorage,
            impressionsStorage,
            clicksStorage,
        )
    }
}