package com.example.demo.router

import com.example.demo.handler.ApiHandler
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import java.util.*

class Router(private val apiHandler: ApiHandler) {
    fun routes(): RouterFunction<ServerResponse> {
        return coRouter {
            GET("/userStats/{userId}") { request ->
                ServerResponse.ok().bodyValueAndAwait(apiHandler.getUserStats(request.getUserIdFromPath()))
            }
        }
    }

    private fun ServerRequest.getUserIdFromPath(): UUID {
        return this.pathVariable("userId").let(UUID::fromString)
    }
}