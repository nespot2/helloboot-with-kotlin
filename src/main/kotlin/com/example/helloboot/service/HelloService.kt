package com.example.helloboot.service

interface HelloService {
    fun sayHello(name: String): String
    fun countOf(name: String): Int
}