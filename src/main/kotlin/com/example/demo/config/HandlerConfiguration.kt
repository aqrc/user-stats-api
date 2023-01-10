package com.example.demo.config

import com.example.demo.handler.ApiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HandlerConfiguration {
    @Bean
    fun apiHandler(): ApiHandler {
        return ApiHandler()
    }
}