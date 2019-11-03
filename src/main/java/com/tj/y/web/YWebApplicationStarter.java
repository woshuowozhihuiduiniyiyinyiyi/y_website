package com.tj.y.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tj.y.web.mapper")
public class YWebApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(YWebApplicationStarter.class, args);
    }
}
