package com.example.helloboot

import com.example.helloboot.controller.HelloController
import com.example.helloboot.service.SimpleHelloService
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.support.registerBean
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet


class HellobootApplication

fun main(args: Array<String>) {

    val applicationContext = GenericWebApplicationContext()
    applicationContext.registerBean<HelloController>()
    applicationContext.registerBean<SimpleHelloService>()
    applicationContext.refresh()
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer({
        it.addServlet("dispatcherServlet", DispatcherServlet(applicationContext))
            .addMapping("/*")
    })

    webServer.start()
}


