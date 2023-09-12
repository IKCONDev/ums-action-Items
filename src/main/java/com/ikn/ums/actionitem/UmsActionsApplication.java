package com.ikn.ums.actionitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UmsActionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsActionsApplication.class, args);
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
