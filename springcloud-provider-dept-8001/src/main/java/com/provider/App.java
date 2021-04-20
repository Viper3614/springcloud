package com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Viper
 * @description
 * @date 2021/4/18
 */

@SpringBootApplication
@EnableEurekaClient  // 服务启动后自动注册到EurekaServer中
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}