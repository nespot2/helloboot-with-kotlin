package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional

/**
 * @author nespot2
 **/
@MyAutoConfiguration
@Conditional(TomcatCondition::class)
class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }
}