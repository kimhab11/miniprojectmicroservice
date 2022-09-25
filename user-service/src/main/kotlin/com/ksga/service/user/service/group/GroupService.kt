package com.ksga.service.user.service.group

import com.ksga.service.user.model.dto.GroupDto
import com.ksga.service.user.model.entity.Group
import com.ksga.service.user.model.request.group.GroupRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface GroupService {

    fun create(groupRequest: GroupRequest) : Mono<GroupDto>

    fun findAll(): Flux<GroupDto>

    fun findById(id: UUID): Mono<GroupDto>

}