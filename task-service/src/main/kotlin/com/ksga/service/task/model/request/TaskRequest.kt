package com.ksga.service.task.model.request

import com.ksga.service.task.model.entity.Task
import java.time.LocalDateTime
import java.util.UUID


data class TaskRequest(
    val title :String,
    val description :String,
    val assignedTo : UUID = UUID.randomUUID(),
    val groupId : UUID = UUID.randomUUID(),
) {

    fun toEntity() = Task(
        title = title,
        description = description,
        createdBy = UUID.randomUUID(), //
        assignedTo =assignedTo,
        groupId = groupId, //
        status = 3,
        createdDate = LocalDateTime.now(),
        lastModified = LocalDateTime.now()
    )

}