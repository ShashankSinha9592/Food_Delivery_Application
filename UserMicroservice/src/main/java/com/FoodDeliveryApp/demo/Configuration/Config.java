package com.FoodDeliveryApp.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;

@Configuration
public class Config {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
