package com.example.helloboot

import com.example.config.MySpringBootApplication
import org.springframework.boot.runApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
