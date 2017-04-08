package com.thoughtworks;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = "com.thoughtworks")
public class Application
{
    public static void main( String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
