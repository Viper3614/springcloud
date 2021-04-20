package com.viper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Viper
 * @description
 * @date 2021/4/20
 */
@SpringBootApplication
@EnableEurekaServer  // 开启EurekaServer的注解
public class AppEureka2 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka2.class, args);
    }
}