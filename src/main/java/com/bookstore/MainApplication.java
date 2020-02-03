package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.newAuthor();
            System.out.println("=========================================");
            System.out.println("=========================================");
            System.out.println("=========================================");
            bookstoreService.longRunningServiceMethod();
            System.out.println("=========================================");
        };
    }
}


/*
 * 
 * 
 * 
 * 
 * Best Way To Use @Transactional

Description: This application is meant to highlight that the best place to use @Transactional for user defined query-methods is in repository interface, and afterwards, depending on situation, on service-methods level.

Key points:

this application is dissected in my book, Spring Boot Persistence Best Practices.

 * 
 * 
 */
