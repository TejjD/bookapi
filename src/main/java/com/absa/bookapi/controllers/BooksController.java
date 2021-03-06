package com.absa.bookapi.controllers;

import com.absa.bookapi.models.Book;
import com.absa.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("api/v1/books")
    public List<Book> listBooks() {
        return bookService.getBooks();
    }

    //Internal Testing
    @PostMapping(value = "api/v1/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            bookService.save(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}