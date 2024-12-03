package com.parking.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.parking.member.client")
public class ParkingMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingMemberApplication.class, args);
    }
}