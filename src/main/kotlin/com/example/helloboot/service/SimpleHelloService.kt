package com.example.helloboot.service

/**
 * @author nespot2
 **/
class SimpleHelloService : HelloService {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}