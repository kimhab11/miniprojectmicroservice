package com.ksga.service.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserServiceApplication {


}


fun main(array: Array<String>){
    runApplication<UserServiceApplication>(
        *array
    )
    println("user")
}