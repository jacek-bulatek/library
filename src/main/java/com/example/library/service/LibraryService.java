package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.PostBookRequest;
import com.example.library.model.PostBookResponse;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    BookRepository bookRepo;

    LibraryService() {

    }

    public Book getBookById(long id) {
        return bookRepo.findById(id).get();
    }

    public ResponseEntity<Book> postBook(PostBookRequest request) {
        Book entry = bookRepo.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
        if (entry != null) {
            entry.setAvailable(entry.getAvailable() + 1);
        } else {
            entry = new Book(request.getTitle(), request.getAuthor());
        }
        try {
            Book _book = bookRepo
                    .save(entry);
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }
}
