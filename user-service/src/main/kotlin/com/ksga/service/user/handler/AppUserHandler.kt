package com.ksga.service.user.handler

import com.fasterxml.jackson.annotation.JsonAlias
import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.request.appuser.AppUserProfileRequest
import com.ksga.service.user.model.request.appuser.AppUserRequest
import com.ksga.service.user.service.appuser.AppUserService
import org.kshrd.cloud.NotFoundException
import org.springframework.cache.Cache
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*
import javax.ws.rs.core.CacheControl

@Component
class AppUserHandler(val appUserService: AppUserService) {

    fun createUser(req : ServerRequest) : Mono<ServerResponse>{

       return req.bodyToMono(AppUserRequest::class.java)
            .flatMap {
                appUserService.create(it)
            }
            .flatMap {
                ServerResponse.status(HttpStatus.CREATED).bodyValue(it)
            }
           .onErrorResume{ ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(mapOf("Message" to it.message))
           }.switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

    }




    fun findUserById(req : ServerRequest) : Mono<ServerResponse>{

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return appUserService.findById(idUUID)
            .flatMap {
                ServerResponse.ok().body(Mono.just(it), AppUserDto::class.java)
            }
            .onErrorResume{
                ServerResponse.status(HttpStatus.NO_CONTENT).cacheControl(org.springframework.http.CacheControl.noCache().sMaxAge(
                    Duration.ZERO).mustRevalidate()).build()
            }.switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());


   }



    fun deleteUserById(req : ServerRequest) : Mono<ServerResponse>{

        val id = req.pathVariable("id")
        val idUUID = UUID.fromString(id)

        return appUserService.deleteByFindId(idUUID)
            .flatMap {
                ServerResponse.ok().body(appUserService.deleteById(it.id),AppUserDto::class.java)
            }
            .onErrorResume{ ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(mapOf("Message" to it.message))
            }.switchIfEmpty(ServerResponse.status(HttpStatus.BAD_REQUEST).build());

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
            .onErrorResume{ ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(mapOf("Message" to it.message))
            }.switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

    }




}


