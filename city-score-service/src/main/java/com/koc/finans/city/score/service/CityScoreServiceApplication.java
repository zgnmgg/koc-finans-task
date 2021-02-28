package com.koc.finans.city.score.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CityScoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityScoreServiceApplication.class, args);
    }

}
