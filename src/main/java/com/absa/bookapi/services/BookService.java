package com.absa.bookapi.services;

import com.absa.bookapi.models.Book;
import com.absa.bookapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(Integer id) {
        return bookRepository.getById(id);
    }
}
