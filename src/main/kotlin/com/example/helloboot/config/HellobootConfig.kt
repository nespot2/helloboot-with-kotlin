package com.example.helloboot.config

import com.example.helloboot.controller.HelloController
import com.example.helloboot.service.HelloService
import com.example.helloboot.service.SimpleHelloService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author nespot2
 **/
@Configuration
class HellobootConfig {
    @Bean
    fun helloController(helloService: HelloService): HelloController {
        return HelloController(helloService)
    }

    @Bean
    fun helloService(): HelloService {
        return SimpleHelloService()
    }
}