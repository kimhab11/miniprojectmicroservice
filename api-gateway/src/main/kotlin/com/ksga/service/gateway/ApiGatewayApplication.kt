package com.ksga.service.gateway


import org.springdoc.core.GroupedOpenApi
import org.springdoc.core.customizers.OpenApiCustomiser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.RouteDefinition
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
class ApiGatewayApplication() {

    @Autowired
    var locator: RouteDefinitionLocator? = null

//

        @Bean
        fun `userAndGroup GroupApi`(): GroupedOpenApi {
            return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/api/v1/users/**","/api/v1/groups/**")
                .addOpenApiCustomiser(openApiCustomiser)
                .build()
        }


        @Bean
        fun taskGroupApi(): GroupedOpenApi {
            return GroupedOpenApi.builder()
                .group("tasks")
                .pathsToMatch("/api/v1/task/**")
                .addOpenApiCustomiser(openApiCustomiser)
                .build()
        }



    //    @Bean
    //    fun jobGroupApi(): GroupedOpenApi {
    //        return GroupedOpenApi.builder()
    //            .group("Group")
    //            .pathsToMatch("/api/v1/groups/**")
    //            .addOpenApiCustomiser(openApiCustomiser)
    //            .build()
    //    }

        val openApiCustomiser: OpenApiCustomiser
            get() = OpenApiCustomiser { openAPI ->
                openAPI.getPaths().values.stream().flatMap { pathItem ->
                    pathItem.readOperations().stream()
                }
    //                .forEach { operation ->
    //                    operation.addParametersItem(
    //                        Parameter().name("Authorization").`in`("header").schema(StringSchema().example("token"))
    //                            .required(true)
    //                    )
    //                    operation.addParametersItem(
    //                        Parameter().name("userId").`in`("header").schema(StringSchema().example("test")).required(true)
    //                    )
    //                }
            }


}


fun main(array: Array<String>){
    runApplication<ApiGatewayApplication>(
        *array
    )
    println("api-gateway")
}