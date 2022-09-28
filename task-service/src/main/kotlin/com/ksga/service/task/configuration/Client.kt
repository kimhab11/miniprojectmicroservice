package com.ksga.service.task.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class Client {


    @Bean("AppUserClient") //make out accessor can use this config
    fun userClient(): WebClient =
        WebClient
            .builder() //prepare an instance
            .baseUrl("http://localhost:8082/")
            .build()


}