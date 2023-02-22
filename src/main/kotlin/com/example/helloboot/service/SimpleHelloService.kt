package com.example.helloboot.service

import com.example.helloboot.repository.HelloRepository
import org.springframework.stereotype.Service

/**
 * @author nespot2
 **/
@Service
class SimpleHelloService(
    private val helloRepository: HelloRepository
) : HelloService {
    override fun sayHello(name: String): String {
        helloRepository.increaseCount(name = name)
        return "Hello $name"
    }

    override fun countOf(name: String): Int {
        return helloRepository.countOf(name = name)
    }
}