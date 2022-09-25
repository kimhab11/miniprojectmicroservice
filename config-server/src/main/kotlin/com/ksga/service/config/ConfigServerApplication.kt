package com.ksga.service.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer


@SpringBootApplication
@EnableConfigServer
class ConfigServerApplication {
}

fun main(array: Array<String>){
    runApplication<ConfigServerApplication>(
        *array
    )
    println("config-server")
}
