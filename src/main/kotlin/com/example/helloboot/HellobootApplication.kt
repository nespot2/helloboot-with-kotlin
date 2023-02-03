package com.example.helloboot

import com.example.helloboot.annotation.MySpringBootAnnotation
import com.example.helloboot.extentions.runApplication

@MySpringBootAnnotation
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
