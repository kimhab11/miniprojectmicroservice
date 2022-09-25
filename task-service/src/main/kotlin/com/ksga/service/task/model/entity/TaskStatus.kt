package com.ksga.service.task.model.entity

import nonapi.io.github.classgraph.json.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("task_status")
data class TaskStatus(

    @Id
    @Column("id")
    val id : Int ? = null,

    @Column("name")
    val name : String,

) {
}