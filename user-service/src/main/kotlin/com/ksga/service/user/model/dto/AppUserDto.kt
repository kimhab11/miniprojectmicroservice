package com.ksga.service.user.model.dto

import java.time.LocalDateTime
import java.util.UUID


data class AppUserDto (

    val id : UUID,
    val username : String,
    val email : String,
    val firstName : String,
    val lastName : String,
    val profileImage : String,
    val createdDate  : LocalDateTime,
    val lastModified : LocalDateTime,
    val isEnabled : Boolean

){

}