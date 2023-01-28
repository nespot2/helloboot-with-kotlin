package com.example.helloboot.servlet

import com.example.helloboot.controller.HelloController
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author nespot2
 **/
class FrontControllerServlet(
    val helloController: HelloController
) : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        //인증, 보안, 다국어, 공통 기능
        if (req.requestURI == "/hello" && req.method == HttpMethod.GET.name) {
            val name: String = req.getParameter("name")
            val response = helloController.hello(name = name)
            resp.status = HttpStatus.OK.value()
            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
            resp.writer.println(response)
        } else {
            resp.status = HttpStatus.NOT_FOUND.value()
        }

    }
}

