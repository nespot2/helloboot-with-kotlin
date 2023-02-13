package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional

/**
 * @author nespot2
 **/
@MyAutoConfiguration
@Conditional(JettyCondition::class)
class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }
}
