package com.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(value = "com.soft.shares.dao")
@EnableEurekaClient
@SpringBootApplication
public class ServerProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerProviderApplication.class, args);
    }

}
