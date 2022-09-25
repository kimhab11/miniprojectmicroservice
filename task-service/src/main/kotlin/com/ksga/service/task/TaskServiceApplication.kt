package com.ksga.service.task

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskServiceApplication {


}


fun main(array: Array<String>){
    runApplication<TaskServiceApplication>(
        *array
    )
    println("task")
}