package com.example.demoonetomany;

import com.example.demoonetomany.service.BookStoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoOneToManyApplication {

    private final BookStoreService bookStoreService;

    public DemoOneToManyApplication(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToManyApplication.class, args);
    }
    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("Insert one author with three books.");
            bookStoreService.insertAuthorWithBooks();
            bookStoreService.deleteBooksOfAuthor();
        };
    }

}
