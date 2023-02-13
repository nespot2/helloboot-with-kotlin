package com.example.helloboot

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata

/**
 * @author nespot2
 **/
class ConditionalTest {
    @Test
    fun `conditional annotation test`() {
        ApplicationContextRunner()
            .withUserConfiguration(Config1::class.java)
            .run {
                assertThat(it).hasSingleBean(MyBean::class.java)
                assertThat(it).hasSingleBean(Config1::class.java)
            }

        ApplicationContextRunner()
            .withUserConfiguration(Config2::class.java)
            .run {
                assertThat(it).doesNotHaveBean(MyBean::class.java)
                assertThat(it).doesNotHaveBean(Config2::class.java)
            }
    }
}


@Configuration
@BooleanConditional(true)
class Config1 {
    @Bean
    fun myBean(): MyBean {
        return MyBean()
    }
}

@Configuration
@BooleanConditional(false)
class Config2 {
    @Bean
    fun myBean(): MyBean {
        return MyBean()
    }
}

class MyBean {

}

class BooleanCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val annotation = metadata.getAnnotationAttributes(BooleanConditional::class.java.name)
        //BooleanConditional annotation attribute 정보 조회
        return annotation?.get("value") as Boolean
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(BooleanCondition::class)
annotation class BooleanConditional(val value: Boolean)



