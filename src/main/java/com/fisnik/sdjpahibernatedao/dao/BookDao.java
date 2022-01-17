package com.fisnik.sdjpahibernatedao.dao;

import com.fisnik.sdjpahibernatedao.domain.Book;

public interface BookDao {

    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
}
