package com.imooc.helloworld.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(HelloworldApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
