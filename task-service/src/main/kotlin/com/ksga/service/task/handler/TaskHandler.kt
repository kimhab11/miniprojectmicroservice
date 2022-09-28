package com.ksga.service.task.handler

import com.ksga.service.task.model.dto.TaskDto
import com.ksga.service.task.model.request.TaskRequest
import com.ksga.service.task.service.TaskService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.UUID

data class AppUser(
    val id : UUID,
    val username : String,
    val email : String,
    val firstName : String,
    val lastName : String
)

@Component
class TaskHandler(val taskService: TaskService) {

    fun createTask(req : ServerRequest):Mono<ServerResponse>{

        return req.bodyToMono(TaskRequest::class.java)
            .flatMap {
                taskService.create(it)
            }
            .flatMap {
                ServerResponse.ok().bodyValue(it)
            }

    }


    fun deleteTask(req : ServerRequest):Mono<ServerResponse> {

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                taskService.deleteById(idUUID),
                TaskDto::class.java
            )

    }




    fun findTaskById(req : ServerRequest):Mono<ServerResponse> {

        val groupId = req.queryParam("group").orElse("groupId").toString()

        val assignedtoId = req.queryParam("assignedto").orElse("assignedtoId").toString()

        return ServerResponse.ok()
            .body(
                taskService.findById(groupId,assignedtoId),
                TaskDto::class.java
            )
    }






}