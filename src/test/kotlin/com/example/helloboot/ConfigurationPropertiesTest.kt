package com.example.helloboot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension


/**
 * @author nespot2
 **/
@ExtendWith(SpringExtension::class)
@EnableConfigurationProperties(value = [ServerProperties::class])
@TestPropertySource("classpath:application.properties")
class ConfigurationPropertiesTest @Autowired constructor(
    private val serverConfig: ServerProperties
) {
    @Test
    fun `test configurationProperties`() {
        assertEquals(8080, serverConfig.port)
        assertEquals("", serverConfig.contextPath)
    }
}

@ConfigurationProperties(prefix = "server")
@Component
data class ServerProperties(
    var contextPath: String,
    var port: Int,
)

