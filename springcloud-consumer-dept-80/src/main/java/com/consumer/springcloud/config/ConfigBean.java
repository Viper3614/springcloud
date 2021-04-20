package com.consumer.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Viper
 * @description
 * @date 2021/4/20
 */

@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}