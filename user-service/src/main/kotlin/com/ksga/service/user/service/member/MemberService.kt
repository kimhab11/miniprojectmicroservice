package com.ksga.service.user.service.member

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.request.member.MemberRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface MemberService {

    fun create(memberRequest: MemberRequest) : Mono<MemberDto>

    fun findById(id: UUID): Flux<AppUserDto>

}