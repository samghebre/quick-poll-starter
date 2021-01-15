package com.codedifferently.quickpoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //This annotation combines other annotations such as @Configuration, @EnableConfiguration, and @ComponentScan
public class QuickPollApplication {


     public static void main(String[] args) {
        SpringApplication.run(QuickPollApplication.class, args);
    }

}
