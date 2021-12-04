package com.giffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class GifferApplication {

    public static void main(String[] args) {
        SpringApplication.run(GifferApplication.class, args);
    }

}
