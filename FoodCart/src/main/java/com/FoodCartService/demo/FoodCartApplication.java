package com.FoodCartService.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Movies Ratings API", version = "1.0", description = "Movies Ratings Information"),
		servers = {
				@Server(url = "/", description = "Movies Ratings Swagger URL")
		}
)
public class FoodCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCartApplication.class, args);
	}

}
