package com.ksga.service.user.router.group

import com.ksga.service.user.handler.GroupHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class GroupRouter(val groupHandler: GroupHandler) {

    @Bean("GroupRouter")
    @GroupOperations
    fun apis():RouterFunction<ServerResponse>{
        return router {
            "/api/v1".nest {
                POST("/groups",groupHandler::createGroup)
                GET("/groups",groupHandler::findAll)
                GET("/groups/{id}",groupHandler::findById)
                POST("/groups/members",groupHandler::createMemberGroup)
                GET("/groups/{id}/users",groupHandler::findMemberByGroupId)
            }
        }
    }


}