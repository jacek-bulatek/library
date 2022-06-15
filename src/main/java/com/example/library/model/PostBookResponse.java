package com.example.library.model;

public class PostBookResponse {
    Book book;
    String status;
    String reason;

    public PostBookResponse(Book book, String status, String reason) {
        this.book = book;
        this.status = status;
        this.reason = reason;
    }
}
