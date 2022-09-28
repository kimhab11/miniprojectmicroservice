package com.ksga.service.user.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.UUID

data class MemberDto(

    val groupId : UUID,
    val userId : Int,
    val addedBy : Int,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val dateAdded : LocalDateTime

) {
}