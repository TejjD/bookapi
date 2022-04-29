package com.absa.bookapi.repositories;

import com.absa.bookapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}