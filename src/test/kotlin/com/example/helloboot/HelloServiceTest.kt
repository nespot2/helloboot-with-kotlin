package com.example.helloboot

import com.example.helloboot.repository.HelloRepository
import com.example.helloboot.service.SimpleHelloService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

/**
 * @author nespot2
 **/
internal class HelloServiceTest {

    @Test
    fun `test simple hello service`() {
        val name = "world"
        val helloRepository = mock<HelloRepository>()
        val helloService = SimpleHelloService(helloRepository = helloRepository)
        val result = helloService.sayHello(name = name)
        then(helloRepository).should(times(1)).increaseCount(name = name)
        assertEquals("Hello world", result)
    }

}