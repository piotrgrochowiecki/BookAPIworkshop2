package com.piotrgrochowiecki.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @ResponseBody
    @RequestMapping("/")
    public String helloHome() {
        return "Hello Spring Web MVC. This is my first REST API";
    }

}
