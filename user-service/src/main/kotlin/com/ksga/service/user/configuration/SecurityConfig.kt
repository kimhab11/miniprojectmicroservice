//package com.ksga.service.user.configuration
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity
//import org.springframework.security.config.web.server.invoke
//import org.springframework.security.web.server.SecurityWebFilterChain
//
//
//@Configuration
//@EnableWebFluxSecurity
//class SecurityConfig {
//
//
//    @Bean
//    fun filterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
//        return http.invoke{
//            cors{}
//            csrf{ disable() }
//            authorizeExchange{
//
//                authorize("/api/v1/user**", authenticated)
//
//                authorize("/api/v1/group**", authenticated)
////                authorize("/api/v1/instance/{userId}", authenticated)
////
////                authorize("/api/v1/user/{id}",permitAll)
////
////                authorize("/api/v1/token",permitAll)
//
//
//                authorize("/v2/api-docs", permitAll)
//                authorize("/swagger-resources",permitAll)
//                authorize("/swagger-resources/**",permitAll)
//                authorize("/configuration/ui",permitAll)
//                authorize("/configuration/security",permitAll)
//                authorize("/swagger-ui.html",permitAll)
//                authorize("/webjars/**",permitAll)
//                authorize("/v3/api-docs/**",permitAll)
//                authorize("/swagger-ui/**",permitAll)
//            }
//
//            oauth2ResourceServer {
//                jwt {}
//            }
//        }
//    }
//
//
//
//
//
//
//
//}