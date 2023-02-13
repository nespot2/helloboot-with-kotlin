package com.example.helloboot

import com.example.helloboot.service.HelloDecorator
import com.example.helloboot.service.SimpleHelloService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author nespot2
 **/
internal class HelloServiceTest {
    @Test
    fun `test simple hello service`() {
        val helloService = SimpleHelloService()
        val result = helloService.sayHello(name = "world!")
        assertEquals("Hello world!", result)
    }

    @Test
    fun `test simple hello decorator`() {
        val decorator = HelloDecorator(SimpleHelloService())
        val result = decorator.sayHello("world!")
        assertEquals("*Hello world!*", result)
    }
}