package com.ksga.service.task.service

import com.ksga.service.task.model.entity.Task
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.UUID

@Repository
interface TaskRepository : ReactiveCrudRepository<Task,UUID>{


    @Query("delete from tasks where id = $1")
    fun deleteByTaskId(id:UUID) : Mono<Task>

    @Query("select * from tasks where id = $1")
    fun findByTaskId(id:UUID) : Mono<Task>

    fun findByGroupIdAndAssignedTo(groupId:UUID,assignedTo :UUID):Mono<Task>

}