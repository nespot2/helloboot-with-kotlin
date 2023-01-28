package com.example.helloboot

import com.example.helloboot.controller.HelloController
import com.example.helloboot.servlet.FrontControllerServlet
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory


class HellobootApplication

fun main(args: Array<String>) {
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer({
        val helloController = HelloController()
        it.addServlet("frontcontroller", FrontControllerServlet(helloController = helloController)).addMapping("/*")
    })

    webServer.start()
}


