package com.ksga.service.user.service.group

import com.ksga.service.user.model.dto.GroupDto
import com.ksga.service.user.model.request.group.GroupRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class GroupServiceImp(val groupRepository: GroupRepository) : GroupService {

    override fun create(groupRequest: GroupRequest): Mono<GroupDto> {
        return  groupRepository.save(groupRequest.toEntity())
            .map { it.toDto() }
    }


    override fun findAll(): Flux<GroupDto> {
        return groupRepository.findAll().map { it.toDto() }
    }


    override fun findById(id: UUID): Mono<GroupDto> {
        return groupRepository.findByGroupId(id)
            .switchIfEmpty(Mono.error(Exception("group not found")))
            .map { it.toDto() }
    }


}