package com.koc.finans.identity.score.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IdentityScoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityScoreServiceApplication.class, args);
    }

}
