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
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
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
                ServerResponse.status(HttpStatus.CREATED).bodyValue(it)
            }
    }



    fun findAll(req : ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body(groupService.findAll(),GroupDto::class.java)
    }



    fun findById(req : ServerRequest) : Mono<ServerResponse>{
        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)
        return groupService.findById(idUUID)
            .flatMap {
                ServerResponse.ok().body(Mono.just(it), GroupDto::class.java)
            }
            .onErrorResume{
                ServerResponse.badRequest().bodyValue(mapOf("message" to it.message))
            }
    }


    fun createMemberGroup(req : ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(MemberRequest::class.java)
            .flatMap {
                memberService.create(it).map { it.groupId }
            }
            .flatMap {
                println(it)
                ServerResponse.ok().bodyValue(mapOf("group" to it))
            }.onErrorResume{
                ServerResponse.badRequest().bodyValue(mapOf("message" to "member already exists in group"))
            }
    }



    fun findMemberByGroupId(req : ServerRequest) : Mono<ServerResponse> {
        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                memberService.findById(idUUID),
                AppUserDto::class.java
            )
            .onErrorResume{
                ServerResponse.badRequest().bodyValue(mapOf("message" to "group not found"))
            }



    }





}