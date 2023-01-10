package com.example.demo.config

import com.example.demo.handler.ApiHandler
import com.example.demo.router.Router
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouterConfiguration {
    @Bean
    fun router(apiHandler: ApiHandler): RouterFunction<ServerResponse> {
        return Router(apiHandler).routes()
    }
}