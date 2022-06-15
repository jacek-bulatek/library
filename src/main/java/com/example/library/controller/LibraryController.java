package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    @Autowired
    LibraryService libService;

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") long id) {
        return libService.getBookById(id);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return libService.getBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> postBook(@Valid @RequestBody Book request, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return libService.postBook(request);
        }
    }

}
