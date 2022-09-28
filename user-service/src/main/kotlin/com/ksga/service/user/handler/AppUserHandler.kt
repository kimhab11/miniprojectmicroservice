package com.ksga.service.user.handler

import com.fasterxml.jackson.annotation.JsonAlias
import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.request.appuser.AppUserProfileRequest
import com.ksga.service.user.model.request.appuser.AppUserRequest
import com.ksga.service.user.service.appuser.AppUserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*

@Component
class AppUserHandler(val appUserService: AppUserService) {

    fun createUser(req : ServerRequest) : Mono<ServerResponse>{

       return req.bodyToMono(AppUserRequest::class.java)
            .flatMap {
                appUserService.create(it)
            }
            .flatMap {
                ServerResponse.ok().bodyValue(it)
            }.switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

    }




    fun findUserById(req : ServerRequest) : Mono<ServerResponse>{

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                appUserService.findById(idUUID),
                AppUserDto::class.java
            )
    }



    fun deleteUserById(req : ServerRequest) : Mono<ServerResponse>{

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return ServerResponse.ok()
            .body(
                appUserService.deleteById(idUUID),
                AppUser::class.java
            )

    }



    fun updateUserById(req : ServerRequest) : Mono<ServerResponse>{

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return req.bodyToMono(AppUserProfileRequest::class.java)
            .flatMap {
                appUserService.updateById(it,idUUID)
            }
            .flatMap {
                ServerResponse.ok().bodyValue(it)
            }
    }




}




data class ApiErrorRespone(
    val message : String,
    @JsonAlias("documentation_url") val docs:String
)