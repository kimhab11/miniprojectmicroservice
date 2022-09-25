package com.ksga.service.user.service.appuser

import com.ksga.service.user.model.entity.AppUser
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.UUID


@Repository
interface AppUserRepository : ReactiveCrudRepository<AppUser,Int>{


    fun findByAuthId(id : UUID) : Mono<AppUser>

    fun deleteByAuthId(id : UUID) : Mono<AppUser>

    @Query(value = "update app_users " +
                   "set username = :username, " +
                   "profile_image = :profileImage, " +
                   "first_name = :firstName, " +
                   "last_name = :lastName " +
                   "where auth_id = :id " +
                   "returning * ")
    fun updateByAuthId(id: UUID, username: String, profileImage: String, firstName: String, lastName: String) : Mono<AppUser>


    @Query(value = "select id from app_users where auth_id = $1")
    fun findIdByAuthId(id : UUID) : Mono<Int>






}