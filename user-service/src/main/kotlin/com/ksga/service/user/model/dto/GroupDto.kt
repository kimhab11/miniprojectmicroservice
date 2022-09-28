package com.ksga.service.user.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.UUID

data class GroupDto (

     val id : UUID,
     val name : String,
     val image : String,
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     val createdDate : LocalDateTime

){
}