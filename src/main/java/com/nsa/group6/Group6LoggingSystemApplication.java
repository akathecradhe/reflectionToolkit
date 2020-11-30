package com.nsa.group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
public class Group6LoggingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group6LoggingSystemApplication.class, args);
    }

}
