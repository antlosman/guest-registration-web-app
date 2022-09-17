package com.guestregistration.guestregistrationwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("<entity>")
@SpringBootApplication
public class GuestRegistrationWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestRegistrationWebAppApplication.class, args);
    }

}
