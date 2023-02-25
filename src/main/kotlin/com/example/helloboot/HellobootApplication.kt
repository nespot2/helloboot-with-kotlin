package com.example.helloboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import javax.annotation.PostConstruct

@SpringBootApplication
class HellobootApplication @Autowired constructor(
    private val jdbcTemplate: JdbcTemplate
) {
    @PostConstruct
    fun init() {
        jdbcTemplate.execute(
            """
            create table if not exists hello(name varchar(50) primary key, count int)
            """
        )
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
