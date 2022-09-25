package com.ksga.service.user.service.member

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.entity.Member
import com.ksga.service.user.model.request.member.MemberRequest
import com.ksga.service.user.service.appuser.AppUserRepository
import org.springframework.stereotype.Service
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




    override fun findById(id: UUID): Mono<AppUserDto> {

        val userIdSearching = appUserRepository.findIdByAuthId(id)
        val appUserDto =  userIdSearching
            .flatMap {
                   memberRepository.findByUserId(it)
            }.map { it.toDto() }
        return appUserDto

    }




}