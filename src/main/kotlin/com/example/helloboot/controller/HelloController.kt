package com.example.helloboot.controller

import com.example.helloboot.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

/**
 * @author nespot2
 **/
@RequestMapping("/myapp")
class HelloController(
    private val helloService: HelloService
) {
    @GetMapping
    @ResponseBody
    fun hello(name: String): String {
        return helloService.sayHello(Objects.requireNonNull(name))
    }
}