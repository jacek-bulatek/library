package com.example.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "author")
    String author;
    @Column(name = "title")
    @NotBlank
    String title;
    @Column(name = "available")
    int available;

    public Book() {
        this.author = "anonymous";
        this.title = null;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        available = 1;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public long bookId() {
        return id;
    }
}
