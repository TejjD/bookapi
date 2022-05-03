package com.absa.bookapi.repositories;

import com.absa.bookapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book WHERE book.isbn13 = ?1",
            nativeQuery = true)
    Book getBooksByIsbn13(String bookId);
}