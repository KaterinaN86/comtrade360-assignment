package com.comtrade360.assignment.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PostConfiguration {

    //making a singleton bean so we can inject it with @Autowired
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder){
        return builder.build();
    }

}
