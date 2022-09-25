package com.ksga.service.user.model.entity

import com.ksga.service.user.model.dto.AppUserDto
import nonapi.io.github.classgraph.json.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("app_users")
 data class AppUser(

  @Id
  @Column("id")
  val id : Int ? = null,

  @Column("auth_id")
  val authId : UUID,

  @Column("email")
  val email : String,

  @Column("username")
  val username : String,

  @Column("first_name")
  val firstName : String,

  @Column("last_name")
  val lastName : String,

  @Column("password")
  val password : String,

  @Column("profile_image")
  val profileImage : String,

  @Column("created_date")
  val createdDate : LocalDateTime,

  @Column("last_modified")
  val lastModified : LocalDateTime,

  @Column("is_enabled")
  val isEnabled : Boolean


  ) {

       fun toDto() = AppUserDto(

         id = authId,
         username = username,
         email = email,
         firstName = firstName,
         lastName = lastName,
         profileImage = profileImage,
         createdDate = createdDate,
         lastModified = lastModified,
         isEnabled = isEnabled

       )


}