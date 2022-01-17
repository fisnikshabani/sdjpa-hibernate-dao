package com.fisnik.sdjpahibernatedao.dao;

import com.fisnik.sdjpahibernatedao.domain.Book;

import java.util.List;

public interface BookDao {

    Book findByISBN(String isbn);

    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);

    List<Book> findAll();
}
