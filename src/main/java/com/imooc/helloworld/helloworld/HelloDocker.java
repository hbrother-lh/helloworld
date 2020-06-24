package com.imooc.helloworld.helloworld;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloDocker {

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable("name")String name) {

        return "hello:"+name;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
