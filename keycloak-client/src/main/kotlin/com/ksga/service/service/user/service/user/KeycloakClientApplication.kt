package com.ksga.service.service.user.service.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication



@SpringBootApplication
class KeycloakClientApplication{
}

fun main(array: Array<String>){
    runApplication<KeycloakClientApplication>(
        *array
    )
    println("keycloak")
}

