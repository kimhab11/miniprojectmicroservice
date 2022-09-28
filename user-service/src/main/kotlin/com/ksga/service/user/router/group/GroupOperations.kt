package com.ksga.service.user.router.group

import com.ksga.service.user.handler.AppUserHandler
import com.ksga.service.user.handler.GroupHandler
import com.ksga.service.user.model.dto.AppUserDto
import com.ksga.service.user.model.dto.GroupDto
import com.ksga.service.user.model.dto.MemberDto
import com.ksga.service.user.model.entity.AppUser
import com.ksga.service.user.model.entity.Member
import com.ksga.service.user.model.request.appuser.AppUserRequest
import com.ksga.service.user.model.request.group.GroupRequest
import com.ksga.service.user.model.request.member.MemberRequest
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
import reactor.core.publisher.Flux


@RouterOperations(
    value = [
        RouterOperation(
            path = "/api/v1/groups",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "createGroup",
            operation = Operation(
                operationId = "createGroup",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = GroupRequest::class))]),
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = GroupDto::class)))]
                    ),
                ],
            ),
        ),




        RouterOperation(
            path = "/api/v1/groups",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "findAll",
            operation = Operation(
                operationId = "findAll",
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = GroupDto::class)))]
                    ),
                ],
            ),
        ),




        RouterOperation(
            path = "/api/v1/groups/{id}",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "findById",
            operation = Operation(
                operationId = "findById",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ],
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = GroupDto::class)))]
                    ),
                ],
            ),
        ),



        RouterOperation(
            path = "/api/v1/groups/members",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "createMemberGroup",
            operation = Operation(
                operationId = "createMemberGroup",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = MemberRequest::class))]),
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = MemberDto::class)))]
                    ),
                ],
            ),
        ),







        RouterOperation(
            path = "/api/v1/groups/{id}/users",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "findMemberByGroupId",
            operation = Operation(
                operationId = "findMemberByGroupId",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ],
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = AppUserDto::class)))]
                    ),
                ],
            ),
        ),




    ]
)
annotation class GroupOperations()
