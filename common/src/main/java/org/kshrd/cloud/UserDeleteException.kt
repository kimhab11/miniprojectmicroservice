package org.kshrd.cloud

class UserDeleteException(userId: String): RuntimeException("Cannot delete id: $userId , not found"){
}