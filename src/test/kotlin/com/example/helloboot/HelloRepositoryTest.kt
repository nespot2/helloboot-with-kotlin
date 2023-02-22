package com.example.helloboot

import com.example.helloboot.repository.HelloRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author nespot2
 **/
@HellobootTest
class HelloRepositoryTest @Autowired constructor(
    private val helloRepository: HelloRepository,
) {

    @Test
    fun findHelloFailed() {
        val name = "toby"
        assertNull(helloRepository.findHello(name = name))
    }

    @Test
    fun increaseCount() {
        assertEquals(0, helloRepository.countOf("toby"))
        helloRepository.increaseCount("toby")
        assertEquals(1, helloRepository.countOf("toby"))
        helloRepository.increaseCount("toby")
        assertEquals(2, helloRepository.countOf("toby"))
    }


}