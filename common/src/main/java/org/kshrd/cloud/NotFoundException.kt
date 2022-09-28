package org.kshrd.cloud

class NotFoundException(userId: String): RuntimeException("Cannot found , id: $userId" ){
}