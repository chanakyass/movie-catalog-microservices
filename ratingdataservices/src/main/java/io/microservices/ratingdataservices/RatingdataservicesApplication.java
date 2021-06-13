package io.microservices.ratingdataservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingdataservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingdataservicesApplication.class, args);
    }

}
