package com.example.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * @author nespot2
 **/
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
annotation class MySpringBootApplication()
