package com.ksga.service.user.model.request.appuser

import com.ksga.service.user.model.entity.AppUser
import java.time.LocalDateTime
import java.util.*

data class AppUserRequest(
    val username : String,
    val email : String,
    val profileImage : String,
    val firstName : String,
    val lastName : String,
    val password : String

) {

    fun toEntity() = AppUser(
        authId = UUID.randomUUID(),
        email = email,
        username = username,
        firstName = firstName,
        lastName = lastName,
        password = password,
        profileImage = profileImage,
        createdDate = LocalDateTime.now(),
        lastModified = LocalDateTime.now(),
        isEnabled = true
    )

}