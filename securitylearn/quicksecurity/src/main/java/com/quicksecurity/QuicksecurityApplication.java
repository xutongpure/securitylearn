package com.quicksecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.mapper")
public class QuicksecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuicksecurityApplication.class, args);
    }

}
