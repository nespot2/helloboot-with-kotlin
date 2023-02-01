package com.example.helloboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

/**
 * @author nespot2
 **/
class HelloApiTest {
    @Test
    fun `hello api`() {
        val name = "world!"
        val restTemplate = TestRestTemplate()
        val responseEntity =
            restTemplate.getForEntity("http://localhost:8080/myapp?name={name}", String::class.java, name)

        //status code 200
        assertEquals(HttpStatus.OK, responseEntity.statusCode)

        //content-type text/plain
        assertThat(responseEntity.headers.getFirst(HttpHeaders.CONTENT_TYPE))
            .startsWith(MediaType.TEXT_PLAIN_VALUE)

        //body Hello world!
        assertEquals("Hello world!", responseEntity.body)
    }
}