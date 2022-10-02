package com.ksga.service.user.router.appuser

import com.ksga.service.user.handler.AppUserHandler
import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.request.appuser.AppUserProfileRequest
import com.ksga.service.user.model.request.appuser.AppUserRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.Explode
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.enums.ParameterStyle
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod


@RouterOperations(
    value = [
        RouterOperation(
            path = "/api/v1/users",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "createUser",
            operation = Operation(
                operationId = "createUser",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = AppUserRequest::class))]),

                ),
        ),



        RouterOperation(
            path = "/api/v1/users/{id}",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "findUserById",
            operation = Operation(
                operationId = "findUserById",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ],

            )
        ),




        RouterOperation(
            path = "/api/v1/users/{id}",
            method = [RequestMethod.DELETE],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "deleteUserById",
            operation = Operation(
                operationId = "deleteUserById",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ]
            )
        ),





        RouterOperation(
            path = "/api/v1/users/profile/{id}",
            method = [RequestMethod.PUT],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "updateUserById",
            operation = Operation(
                operationId = "updateUserById",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ],
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = AppUserProfileRequest::class))]),
                )
        ),





    ]
)
annotation class `AppUserOperations`()
