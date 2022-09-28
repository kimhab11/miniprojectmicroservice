package com.ksga.service.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableDiscoveryClient
@Configuration

class ApiGatewayApplication() {
}


fun main(array: Array<String>){
    runApplication<ApiGatewayApplication>(
        *array
    )
    println("api-gateway")
}