package com.jithspycca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.jithspycca.rest")
public class JithspyccaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JithspyccaApplication.class, args);


	}
}
