package com.microservice.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
public class NotificationService {
    public static void main(String[] args) {
        SpringApplication.run(NotificationService.class ,args);
    }

}
