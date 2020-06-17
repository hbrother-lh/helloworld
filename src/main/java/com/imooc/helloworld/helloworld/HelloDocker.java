package com.imooc.helloworld.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "helloDockerNgrok";
    }
}
