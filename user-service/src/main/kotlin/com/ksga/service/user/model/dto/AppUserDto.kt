package com.ksga.service.user.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.UUID


data class AppUserDto (

    val id : UUID,
    val username : String,
    val email : String,
    val firstName : String,
    val lastName : String,
    val profileImage : String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdDate  : LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val lastModified : LocalDateTime,
    val isEnabled : Boolean

){

}