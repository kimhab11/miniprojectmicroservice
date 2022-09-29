package com.ksga.service.task.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.ksga.service.task.handler.AppUser
import java.time.LocalDateTime
import java.util.UUID

data class TaskDto(

    val id : UUID,
    val title : String,
    val description : String,
    var createdBy : AppUser ? = null,
    var assignedTo : AppUser ? = null,
    val groupId : UUID,
    val status : String? =null,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdDate : LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val lastModified : LocalDateTime

) {
}