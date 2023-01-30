package com.example.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class HellobootApplication

fun main(args: Array<String>) {
    AnnotationConfigWebApplicationContext().apply {
        register(HellobootApplication::class.java)
        refresh()
        val serverFactory = TomcatServletWebServerFactory()
        val webServer = serverFactory.getWebServer({
            it.addServlet("dispatcherServlet", DispatcherServlet(this))
                .addMapping("/*")
        })
        webServer.start()
    }
}






