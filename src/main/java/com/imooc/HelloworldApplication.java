package com.imooc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.imooc.dao")
public class HelloworldApplication {

	public static void main(String[] args) {
	    SpringApplication.run(HelloworldApplication.class, args);
	}

}
