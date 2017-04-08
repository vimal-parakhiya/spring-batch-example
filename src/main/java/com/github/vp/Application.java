package com.github.vp;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.github.vp")
@EnableBatchProcessing
public class Application {
    public static void main( String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
