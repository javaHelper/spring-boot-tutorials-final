package com.mkyong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
