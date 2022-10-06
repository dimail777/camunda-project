package org.camunda.project;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {
    public static void main(String... args) {
        // https://docs.camunda.org/get-started/spring-boot/
        SpringApplication.run(WebappExampleProcessApplication.class, args);
    }
}
