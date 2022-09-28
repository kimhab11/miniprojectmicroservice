package com.ksga.service.user.handler

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.GroupDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.entity.Group
import com.ksga.service.user.model.request.appuser.AppUserRequest
import com.ksga.service.user.model.request.group.GroupRequest
import com.ksga.service.user.model.request.member.MemberRequest
import com.ksga.service.user.service.group.GroupService
import com.ksga.service.user.service.member.MemberService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*

@Component
class GroupHandler(val groupService: GroupService,val memberService: MemberService) {

    fun createGroup(req : ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(GroupRequest::class.java)
            .flatMap {
                groupService.create(it)
            }
            .flatMap {
                println(it)
                ServerResponse.ok().bodyValue(it)
            }
    }



    fun findAll(req : ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body(groupService.findAll(),GroupDto::class.java)
    }



    fun findById(req : ServerRequest) : Mono<ServerResponse>{
        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                groupService.findById(idUUID),
                GroupDto::class.java
            )
    }


    fun createMemberGroup(req : ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(MemberRequest::class.java)
            .flatMap {
                memberService.create(it)
            }
            .flatMap {
                println(it)
                ServerResponse.ok().bodyValue(it)
            }
    }



    fun findMemberByGroupId(req : ServerRequest) : Mono<ServerResponse>{
        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                memberService.findById(idUUID),
                AppUserDto::class.java
            )
    }




}