package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import com.example.config.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder.get
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils.findAnnotation
import org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes
import org.springframework.core.env.Environment

/**
 * @author nespot2
 **/
@MyAutoConfiguration
class PropertyPostProcessorConfig {

    @Bean
    fun propertyPostProcessor(env: Environment): BeanPostProcessor {
        return object : BeanPostProcessor {
            override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
                val annotation = findAnnotation(bean.javaClass, MyConfigurationProperties::class.java)
                return if (annotation == null) {
                    bean
                } else {
                    val attr = getAnnotationAttributes(annotation)
                    val prefix = attr["prefix"] as String
                    get(env).bindOrCreate(prefix, bean.javaClass)
                }

            }
        }
    }
}