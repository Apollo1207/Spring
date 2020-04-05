package ua.lviv.iot.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class RestApplication {
    public static void main(final String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
