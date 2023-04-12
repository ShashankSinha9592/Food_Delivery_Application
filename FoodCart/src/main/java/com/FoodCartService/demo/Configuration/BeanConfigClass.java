package com.FoodCartService.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfigClass {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
