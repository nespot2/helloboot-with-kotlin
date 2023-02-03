package com.example.config.autoconfig

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

/**
 * @author nespot2
 **/
@Configuration
class DispatcherServletConfig {
    /**
     * ApplicationContextAware setApplicationContext 메소드를 이용하여 ApplicationContext를 주입받는다.
     */
    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}