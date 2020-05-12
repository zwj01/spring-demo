package com.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@MapperScan("com.soft.dao.mybatis")
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ServerLinktraceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerLinktraceApplication.class, args);
    }

}
