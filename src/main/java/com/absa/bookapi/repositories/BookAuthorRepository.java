package com.absa.bookapi.repositories;

import com.absa.bookapi.models.BookAuthor;
import com.absa.bookapi.models.BookAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {
}