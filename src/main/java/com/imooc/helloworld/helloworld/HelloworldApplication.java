package com.imooc.helloworld.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloworldApplication {

	public static void main(String[] args) {
	    SpringApplication.run(HelloworldApplication.class, args);
	}

}
