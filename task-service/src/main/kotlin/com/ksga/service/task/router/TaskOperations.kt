package com.ksga.service.task.router

import com.ksga.service.task.handler.TaskHandler
import com.ksga.service.task.model.dto.TaskDto
import com.ksga.service.task.model.request.TaskRequest
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
            path = "/api/v1/tasks",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = TaskHandler::class,
            beanMethod = "createTask",
            operation = Operation(
                operationId = "createTask",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = TaskRequest::class))]),
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = TaskDto::class)))]
                    ),
                ],
            ),
        ),



        RouterOperation(
            path = "/api/v1/tasks/{id}",
            method = [RequestMethod.DELETE],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = TaskHandler::class,
            beanMethod = "deleteTask",
            operation = Operation(
                operationId = "deleteTask",
                parameters = [
                    Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    ),
                ],
            ),
        ),




        RouterOperation(
            path = "/api/v1/tasks/{id}",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = TaskHandler::class,
            beanMethod = "findTaskById",
            operation = Operation(
                operationId = "findTaskById",
                parameters = [
                    Parameter(
                        name = "group",
                        `in` = ParameterIn.QUERY,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                        description = "Required to get tasks of each group"
                    ),
                    Parameter(
                        name = "assignedto",
                        `in` = ParameterIn.QUERY,
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        description = "Not required but can be used to filter for users of a group's task"
                    ),
                ],
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = TaskDto::class)))]
                    ),
                ],
            ),
        ),


    ]
)
annotation class TaskOperations()
