package com.ksga.service.user.service.member

import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.entity.Member
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*


@Repository
interface MemberRepository : ReactiveCrudRepository<Member,UUID>{

    @Query(
        value = "select distinct app_users.* from app_users   " +
                "inner join group_members  on group_members.user_id = app_users.id " +
                " where group_members.user_id = :id "
    )
    fun findByUserId(id:Int) : Mono<AppUser>


}