package com.example.helloboot

import com.example.helloboot.config.HellobootConfig
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class HellobootApplication

fun main(args: Array<String>) {
    AnnotationConfigWebApplicationContext().apply {
        register(HellobootConfig::class.java)
        refresh()
        val serverFactory = TomcatServletWebServerFactory()
        val webServer = serverFactory.getWebServer({
            it.addServlet("dispatcherServlet", DispatcherServlet(this))
                .addMapping("/*")
        })
        webServer.start()
    }


}





