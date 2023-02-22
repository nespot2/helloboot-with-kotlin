package com.example.helloboot.controller

import com.example.helloboot.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * @author nespot2
 **/
@RequestMapping("/myapp")
@RestController
class HelloController(
    private val helloService: HelloService
) {
    @GetMapping
    fun hello(name: String): String {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }

        return helloService.sayHello(name)
    }

    @GetMapping("/count")
    fun countOf(name: String): String {
        return helloService.countOf(name = name).toString()
    }
}