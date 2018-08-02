package com.law;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class LawConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LawConfigClientApplication.class, args);
	}
	
	@Value("${foo}")
	String foo;
	@GetMapping(value = "/foo")
	public String hi(){
		return foo;
	}
}
