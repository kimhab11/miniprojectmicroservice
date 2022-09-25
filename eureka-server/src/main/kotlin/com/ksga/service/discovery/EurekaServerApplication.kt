package com.ksga.service.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer


@SpringBootApplication
@EnableEurekaServer
class EurekaServerApplication {
}

fun main(array: Array<String>){
    runApplication<EurekaServerApplication>(
        *array
    )
    println("eureka-server")
}