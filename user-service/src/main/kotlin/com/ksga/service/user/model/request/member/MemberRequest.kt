package com.ksga.service.user.model.request.member

import com.ksga.service.user.model.entity.Member
import java.time.LocalDateTime
import java.util.UUID

data class MemberRequest(

    val groupId : UUID,
    val userId : UUID

) {

    fun toEntity(id:Int) = Member(
        groupId =  groupId,
        userId = id,
        addedBy = id,
        dateAdded = LocalDateTime.now()
    )

}