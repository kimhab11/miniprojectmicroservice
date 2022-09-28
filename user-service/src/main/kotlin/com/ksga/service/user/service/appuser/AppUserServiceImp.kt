package com.ksga.service.user.service.appuser

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.request.appuser.AppUserProfileRequest
import com.ksga.service.user.model.request.appuser.AppUserRequest
import org.kshrd.cloud.NotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class AppUserServiceImp(val appUserRepository: AppUserRepository) : AppUserService{

    override fun create(appUserRequest: AppUserRequest): Mono<AppUserDto> {
        return appUserRepository.save(appUserRequest.toEntity()).map { it.toDto() }
    }

    override fun findById(id: UUID): Mono<AppUserDto> {
        return  appUserRepository.findByAuthId(id).log()
            .switchIfEmpty(Mono.error(NotFoundException("$id")))
            .map { it.toDto() }

    }

    override fun deleteById(id: UUID): Mono<AppUser> {
        return   appUserRepository.deleteByAuthId((id))
    }

    override fun updateById(appUserProfileRequest: AppUserProfileRequest, id: UUID): Mono<AppUserDto> {

        val username = appUserProfileRequest.username
        val profileImage = appUserProfileRequest.profileImage
        val firstName = appUserProfileRequest.firstName
        val lastName = appUserProfileRequest.lastName

        return   appUserRepository.updateByAuthId(id,username,profileImage,firstName,lastName).map { it.toDto() }
    }

}