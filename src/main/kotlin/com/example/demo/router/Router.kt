package com.example.demo.router

import com.example.demo.model.UserStats
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import java.util.*

class Router {
    fun routes() : RouterFunction<ServerResponse> {
        return coRouter {
            GET("/userStats") {
                ServerResponse.ok().bodyValueAndAwait(UserStats(
                    UUID.randomUUID(),
                    1, 2,3,4.3f
                ))
            }
        }
    }
}