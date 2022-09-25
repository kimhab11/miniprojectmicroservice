package com.ksga.service.task.router

import com.ksga.service.task.handler.TaskHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class TaskRouter(val taskHandler: TaskHandler) {

    @Bean("TaskRouter")
    @TaskOperations
    fun apis():RouterFunction<ServerResponse>{

        return router {
            "/api/v1".nest {
                POST("/tasks",taskHandler::createTask)
                DELETE("/tasks/{id}",taskHandler::deleteTask)
                GET("/tasks/{id}",taskHandler::findTaskById)
            }
        }

    }


}