package com.ksga.service.user.router.appuser

import com.ksga.service.user.handler.AppUserHandler
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.Explode
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.enums.ParameterStyle
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class AppUserRouter (val appUserHandler: AppUserHandler){
    @Bean("AppUserRouter")
    @AppUserOperations
    fun apis():RouterFunction<ServerResponse>{
        return router {
            "/api/v1".nest {
                POST("/users",appUserHandler::createUser)
                GET("/users/{id}",appUserHandler::findUserById)
                DELETE("/users/{id}",appUserHandler::deleteUserById)
                PUT("/users/profile/{id}",appUserHandler::updateUserById)
            }
        }
    }


}