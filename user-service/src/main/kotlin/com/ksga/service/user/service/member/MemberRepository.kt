package com.ksga.service.user.service.member

import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.entity.Member
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*


@Repository
@Component
 interface MemberRepository : ReactiveCrudRepository<Member,UUID>{


    @Query(
        value = "select  * from app_users   " +
                "inner join group_members  on group_members.user_id = app_users.id " +
                " where group_members.group_id = :groupId "
    )
    fun findByUserGroupId(groupId: UUID): Flux<AppUser>
    @Query("select exists (select 1 from group_members where group_id = :groupId)")
    fun findByGroupId(groupId: UUID): Mono<Boolean>


}