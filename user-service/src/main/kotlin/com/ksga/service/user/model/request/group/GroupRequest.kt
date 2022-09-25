package com.ksga.service.user.model.request.group

import com.ksga.service.user.model.entity.Group
import java.time.LocalDateTime

data class GroupRequest (

    val name : String,
    val image :  String

){

    fun toEntity() = Group(
        groupName = name,
        groupImage = image,
        createdDate = LocalDateTime.now()
    )

}