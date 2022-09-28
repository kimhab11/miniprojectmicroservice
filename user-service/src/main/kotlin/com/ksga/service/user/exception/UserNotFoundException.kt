package com.ksga.service.user.exception

class UserNotFoundException(userId: String): RuntimeException("User not found , id: $userId" ){
}