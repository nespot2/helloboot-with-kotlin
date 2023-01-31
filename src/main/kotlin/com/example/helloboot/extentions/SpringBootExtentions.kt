package com.example.helloboot.extentions

import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

/**
 * @author nespot2
 **/
inline fun <reified T : Any> runApplication(vararg args: String) {
    AnnotationConfigWebApplicationContext().apply {
        register(T::class.java)
        refresh()
        val serverFactory = this.getBean(ServletWebServerFactory::class.java)
        val dispatcherServlet = this.getBean(DispatcherServlet::class.java)
        val webServer = serverFactory.getWebServer({
            it.addServlet("dispatcherServlet", dispatcherServlet)
                .addMapping("/*")
        })
        webServer.start()
    }
}
