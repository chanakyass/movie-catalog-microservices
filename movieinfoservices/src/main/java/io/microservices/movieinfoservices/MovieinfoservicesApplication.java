package io.microservices.movieinfoservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieinfoservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieinfoservicesApplication.class, args);
    }

}
