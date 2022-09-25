package com.ksga.service.task.model.entity

import com.ksga.service.task.model.dto.TaskDto
import nonapi.io.github.classgraph.json.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("tasks")
data class Task(

    @Id
    @Column("id")
    val id : UUID = UUID.randomUUID(),

    @Column("title")
    val title:String,

    @Column("description")
    val description : String,

    @Column("created_by")
    val createdBy : UUID,

    @Column("assigned_to")
    val assignedTo : UUID,

    @Column("group_id")
    val groupId : UUID,

    @Column("status")
    val status : Int,

    @Column("created_date")
    val createdDate : LocalDateTime,

    @Column("last_modified")
    val lastModified : LocalDateTime


) {


    fun toDto () = TaskDto(
        id = id,
        title = title,
        description = description,
        createdBy = null,
        assignedTo = null,
        groupId = groupId,
        status = "REQUESTING",
        createdDate = createdDate,
        lastModified = lastModified
    )



}