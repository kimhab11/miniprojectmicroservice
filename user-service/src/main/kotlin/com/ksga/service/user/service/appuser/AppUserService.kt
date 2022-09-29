package com.ksga.service.user.service.appuser

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.request.appuser.AppUserProfileRequest
import com.ksga.service.user.model.request.appuser.AppUserRequest
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserService {

    fun create(appUserRequest: AppUserRequest) : Mono<AppUserDto>

    fun findById(id: UUID): Mono<AppUserDto>

    fun deleteByFindId(id: UUID): Mono<AppUserDto>

    fun deleteById(idUUID: UUID): Mono<AppUser>

    fun updateById(appUserProfileRequest: AppUserProfileRequest, id: UUID) : Mono<AppUserDto>

}