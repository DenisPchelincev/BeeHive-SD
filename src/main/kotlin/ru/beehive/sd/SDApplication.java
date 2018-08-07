package ru.beehive.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SDApplication {

    public static void main(String[] args) {
        SpringApplication.run(SDApplication.class, args);
    }
}
