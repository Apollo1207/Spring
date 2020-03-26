package ua.lviv.iot.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.spring.demo.dataaccess", "ua.lviv.iot.spring.demo.business",
        "ua.lviv.iot.spring.demo.controller"
})
@EnableJpaRepositories({"ua.lviv.iot.spring.demo.dataaccess"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
