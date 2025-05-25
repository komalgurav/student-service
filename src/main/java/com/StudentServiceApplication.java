package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EntityScan(basePackages = {"com.entity"})
@EnableJpaRepositories(basePackages = {"com.repository"})
@EnableFeignClients(basePackages = {"com.feignclients"})
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	@Bean
	WebClient webClient() {
		//WebClient needs webflux dependency
		//in order to call different microservice application
		//can use openfeign as alternative as openfeign is a declarative approach
		//open feign provides same annotations as inside the controller like RequestBody/PathVariable
		WebClient webClient = WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;
	}


}
