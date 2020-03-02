package com.springBootOlolo2Demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootOlolo2Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOlolo2Demo2Application.class, args);
    }
}
