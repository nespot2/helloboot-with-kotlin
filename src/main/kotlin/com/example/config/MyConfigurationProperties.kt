package com.example.config

import org.springframework.stereotype.Component

/**
 * @author nespot2
 **/
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Component
annotation class MyConfigurationProperties(
    val prefix: String
) {
}