package com.example.helloboot.repository

import com.example.helloboot.domain.Hello
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class HelloRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate
) : HelloRepository {
    override fun findHello(name: String): Hello? {
        return try {

            val hello = jdbcTemplate.queryForObject(
                "select * from hello where name = '$name'"
            ) { rs, _ ->
                val name = rs.getString("name")
                val count = rs.getInt("count")
                Hello(name = name, count = count)
            }
            hello
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    override fun increaseCount(name: String) {
        val hello = findHello(name = name)
        if (hello == null) {
            jdbcTemplate.update("insert into hello(name, count) values(?, ?)", name, 1)
        } else {
            jdbcTemplate.update("update hello set count = ? where name = ?", hello.count + 1, name)
        }
    }
}