package com.example.config

import org.springframework.context.annotation.Import

/**
 * @author nespot2
 **/
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(MyAutoConfigImportSelector::class)
annotation class EnableMyAutoConfiguration()
