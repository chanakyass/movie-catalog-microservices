package io.microservices.moviecatalogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServicesApplication.class, args);
    }

}
