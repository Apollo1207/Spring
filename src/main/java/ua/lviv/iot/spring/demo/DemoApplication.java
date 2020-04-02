package ua.lviv.iot.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class DemoApplication {
    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
