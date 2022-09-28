package com.ksga.service.user.service.member

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.request.member.MemberRequest
import com.ksga.service.user.service.appuser.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class MemberServiceImp(val memberRepository: MemberRepository,val appUserRepository: AppUserRepository) :MemberService {


    override fun create(memberRequest: MemberRequest): Mono<MemberDto> {
        val userId = memberRequest.userId
        val userIdSearching = appUserRepository.findIdByAuthId(userId)
        val memberDto = userIdSearching.flatMap {
            memberRepository.save(memberRequest.toEntity(it))
        }.map { it.toDto() }

        return memberDto
    }




    override fun findById(id: UUID): Flux<AppUserDto> {
        return memberRepository.findByUserGroupId(id).map { it.toDto() }
    }




}