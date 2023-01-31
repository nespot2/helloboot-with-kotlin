package com.example.helloboot

import com.example.helloboot.extentions.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class HellobootApplication {
    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }

    /**
     * ApplicationContextAware setApplicationContext 메소드를 이용하여 ApplicationContext를 주입받는다.
     */
    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}







