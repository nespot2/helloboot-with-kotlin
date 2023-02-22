package com.example.helloboot.repository

import com.example.helloboot.domain.Hello

/**
 * @author nespot2
 **/
interface HelloRepository {
    fun findHello(name: String): Hello?
    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        val hello = findHello(name)
        return hello?.count ?: 0
    }

}