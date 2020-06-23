package com.imooc.helloworld.helloworld;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable("name")String name) {
        return "helloDockerNgrokWhy"+name;
    }
}
