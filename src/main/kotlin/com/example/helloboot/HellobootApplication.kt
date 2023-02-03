package com.example.helloboot

import com.example.config.MySpringBootApplication
import com.example.helloboot.extentions.runApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
