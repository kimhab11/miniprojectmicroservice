package org.kshrd.cloud

class UserDeleteException(userId: String): RuntimeException("user with specified id does not exist"){
}