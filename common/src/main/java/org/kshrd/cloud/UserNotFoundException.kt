package org.kshrd.cloud

class UserNotFoundException(userId: String): RuntimeException("Cannot found , id: $userId" ){
}