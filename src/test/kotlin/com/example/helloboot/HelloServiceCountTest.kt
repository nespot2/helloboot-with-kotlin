package com.example.helloboot

import com.example.helloboot.repository.HelloRepository
import com.example.helloboot.service.HelloService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

/**
 * @author nespot2
 **/

@SpringBootTest
@Transactional
internal class HelloServiceCountTest @Autowired constructor(
    private val helloService: HelloService,
    private val helloRepository: HelloRepository
) {
    @Test
    fun sayHelloIncreaseCount() {
        (1..10).forEach {
            helloService.sayHello(name = "toby")
            assertEquals(it, helloRepository.countOf(name = "toby"))
        }
    }
}