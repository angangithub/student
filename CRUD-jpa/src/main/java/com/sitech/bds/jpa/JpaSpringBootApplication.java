package com.sitech.bds.jpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSpringBootApplication.class, args);

        System.out.println("========================>JPA Start");
    }

}
