package com.example.helloboot

import com.example.helloboot.service.SimpleHelloService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author nespot2
 **/
class HelloServiceTest {
    @Test
    fun `test simple hello service`() {
        val helloService = SimpleHelloService()
        val result = helloService.sayHello(name = "world!")
        assertEquals("Hello world!", result)
    }
}