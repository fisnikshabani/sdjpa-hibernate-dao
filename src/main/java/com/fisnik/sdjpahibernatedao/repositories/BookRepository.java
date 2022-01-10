package com.fisnik.sdjpahibernatedao.repositories;

import com.fisnik.sdjpahibernatedao.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
