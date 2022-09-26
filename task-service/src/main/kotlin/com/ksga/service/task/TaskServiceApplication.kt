package com.ksga.service.task

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.security.OAuthFlow
import io.swagger.v3.oas.annotations.security.OAuthFlows
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux


@EnableWebFlux
@OpenAPIDefinition(
    servers = [Server(url = "/", description = "Default Server URL")],
    info = Info(
        title = "Control Tower: Task Service",
        description = "Spring Boot API for creating and managing tasks.",
        version = "1.0.0"
    )
)
@SecurityScheme(
    name = "oauth2security",
    type = SecuritySchemeType.OAUTH2,
    `in` = SecuritySchemeIn.HEADER,
    flows = OAuthFlows(
        clientCredentials = OAuthFlow(
            tokenUrl = "https://auth.saintrivers.tech/auth/realms/control-tower/protocol/openid-connect/token"
        ),
        password = OAuthFlow(
            tokenUrl = "https://auth.saintrivers.tech/auth/realms/control-tower/protocol/openid-connect/token",
        )
    )
)
@SpringBootApplication
class TaskServiceApplication {


}


fun main(array: Array<String>){
    runApplication<TaskServiceApplication>(
        *array
    )
    println("task")
}