package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@EnableConfigurationProperties
@SpringBootApplication
public class ZookeeperApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ZookeeperApplication.class, args);
    }
}
