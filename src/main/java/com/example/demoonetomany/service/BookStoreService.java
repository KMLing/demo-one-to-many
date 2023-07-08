package com.example.demoonetomany.service;

import com.example.demoonetomany.entities.Author;
import com.example.demoonetomany.entities.Book;
import com.example.demoonetomany.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookStoreService {

    private final AuthorRepository authorRepository;

    public BookStoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Transactional
    public void insertAuthorWithBooks(){
        Author jn=new Author("Joana Nimar","History",34);

        Book book1=new Book("World History","000-Jn");
        Book book2=new Book("Ancient History","001-Jn");
        Book book3=new Book("War History","002-JN");



        jn.addBooks(book1);
        jn.addBooks(book2);
        jn.addBooks(book3);

        authorRepository.save(jn);


    }
    @Transactional
    public void deleteBooksOfAuthor(){
        Author author=authorRepository.fetchByName("Joana Nimar");
        Book book=author.getBooks().get(1);
        author.removeBook(book);
    }


}
