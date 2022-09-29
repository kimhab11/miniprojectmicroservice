package com.ksga.service.task.service

import com.ksga.service.task.handler.AppUser
import com.ksga.service.task.model.dto.TaskDto
import com.ksga.service.task.model.request.TaskRequest
import com.ksga.service.user.service.member.MemberRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.*

@Service
class TaskServiceImp(
    val taskRepository: TaskRepository,
    @Qualifier("AppUserClient") val appUserClient: WebClient,
) : TaskService {



    override fun create(taskRequest: TaskRequest): Mono<TaskDto> {

        val assignedToUser = taskRequest.assignedTo


        val taskMono =  taskRepository.save(taskRequest.toEntity())
            .map { it.toDto()}

        val createdBy = appUserClient.get()
            .uri("/api/v1/users/{id}", "f1e2cd2f-d60f-40a0-9339-a16f671e6dca")
            .retrieve()
            .bodyToMono(AppUser::class.java)


        val taskCreatedByMono = taskMono.zipWith(createdBy)
            .map {
                val task = it.t1
                val createdBy = it.t2
                val taskResponse = task
                taskResponse.createdBy = createdBy
                taskResponse
            }



        val assignedToMono = appUserClient.get()
            .uri("/api/v1/users/{id}",assignedToUser )
            .retrieve()
            .bodyToMono(AppUser::class.java)



        val taskCreatedByAssignedToMono = taskCreatedByMono.zipWith(assignedToMono)
            .map {
                val taskCreatedBy = it.t1
                val assignedTo = it.t2
                val taskCreatedByResponse = taskCreatedBy
                taskCreatedByResponse.assignedTo = assignedTo
                taskCreatedByResponse
            }


        return taskCreatedByAssignedToMono
    }



    override fun deleteById(id: UUID): Mono<TaskDto> {
            return taskRepository.deleteByTaskId(id).map { it.toDto() }
    }


    override fun findById(id: String, assignedto: String): Mono<TaskDto> {

        val groupId = UUID.fromString(id)
        val assignedtoId = UUID.fromString(assignedto)

        val taskMono = taskRepository.findByGroupIdAndAssignedTo(groupId,assignedtoId).map { it.toDto() }

        val createdBy = appUserClient.get()
            .uri("/api/v1/users/{id}", "3986fced-4424-4825-9912-589e626e53b3")
            .retrieve()
            .bodyToMono(AppUser::class.java)


        val taskCreatedByMono = taskMono.zipWith(createdBy)
            .map {
                val task = it.t1
                val createdBy = it.t2
                val taskResponse = task
                taskResponse.createdBy = createdBy
                taskResponse
            }



        val assignedToMono = appUserClient.get()
            .uri("/api/v1/users/{id}",assignedtoId )
            .retrieve()
            .bodyToMono(AppUser::class.java)



        val taskCreatedByAssignedToMono = taskCreatedByMono.zipWith(assignedToMono)
            .map {
                val taskCreatedBy = it.t1
                val assignedTo = it.t2
                val taskCreatedByResponse = taskCreatedBy
                taskCreatedByResponse.assignedTo = assignedTo
                taskCreatedByResponse
            }


        return taskCreatedByAssignedToMono

    }


}