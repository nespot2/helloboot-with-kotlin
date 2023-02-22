package com.example.helloboot

import com.example.helloboot.controller.HelloController
import com.example.helloboot.service.HelloService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * @author nespot2
 **/
internal class HelloControllerTest {

    @Test
    fun `test hello controller`() {

        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String {
                return "kiki $name"
            }

            override fun countOf(name: String): Int {
                return 0
            }
        })

        val result1 = helloController.hello(name = "bye")
        assertEquals("kiki bye", result1)

        assertThrows<IllegalArgumentException> {
            helloController.hello("")
        }

    }


}