package com.example.helloboot

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

/**
 * @author nespot2
 **/
@HellobootTest
class JdbcTemplateTest @Autowired constructor(
    private val jdbcTemplate: JdbcTemplate
) {

    @Test
    fun `insert and query`() {
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "Toby", 1)
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "Spring", 2)
        val count = jdbcTemplate.queryForObject("select count(*) from hello", Long::class.java)

        assertEquals(2, count)
    }

}