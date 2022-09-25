package com.ksga.service.task.service

import com.ksga.service.task.model.dto.TaskDto
import com.ksga.service.task.model.request.TaskRequest
import reactor.core.publisher.Mono
import java.util.UUID


interface TaskService {

    fun create(taskRequest: TaskRequest) : Mono<TaskDto>

    fun deleteById(id: UUID):  Mono<TaskDto>

    fun findById(id: UUID):   Mono<TaskDto>


}