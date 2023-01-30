package com.example.helloboot.service

import org.springframework.stereotype.Service

/**
 * @author nespot2
 **/
@Service
class SimpleHelloService : HelloService {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}