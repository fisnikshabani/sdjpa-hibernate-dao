package com.fisnik.sdjpahibernatedao.repositories;

import com.fisnik.sdjpahibernatedao.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
