package com.example.SpringWebApplication.sayhellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController  dont need response body with rest controller
@Controller
public class SayHelloController {

    @GetMapping("/hello")
    @ResponseBody
//    Response Body converts the string to html pages body
    public String sayHello() {
        return "Hello Spring Web Tut";
    }

    @GetMapping("/hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
//        It returns a .jsp page named sayHello.jsp using tomcat jasper dependency and suffix, prefix stored in .properties
    }

}
