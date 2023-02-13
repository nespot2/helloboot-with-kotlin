package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet

/**
 * @author nespot2
 **/
@MyAutoConfiguration
class DispatcherServletConfig {
    /**
     * ApplicationContextAware setApplicationContext 메소드를 이용하여 ApplicationContext를 주입받는다.
     */
    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}