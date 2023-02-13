package com.example.config

import org.springframework.context.annotation.Conditional

/**
 * @author nespot2
 **/
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(MyOnClassCondition::class)
annotation class ConditionalMyOnClass(val value: String) {
}