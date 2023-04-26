package com.infinityworks.techtest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.infinityworks.techtest")
public class IwTechTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IwTechTestApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplateBean(){
		return new RestTemplate();
	}


}
