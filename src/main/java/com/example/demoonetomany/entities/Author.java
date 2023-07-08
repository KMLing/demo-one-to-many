package com.example.demoonetomany.entities;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author implements Serializable {

    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "author")

    private List<Book> books=new ArrayList<>();
    public void addBooks(Book book){

        this.books.add(book);
        book.setAuthor(this);
    }


    public void removeBook(Book book){
        book.setAuthor(null);
        this.books.remove(book);
    }



    public Author() {
    }

    public Author(String name, String genre, int age) {
        this.name = name;
        this.genre = genre;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
