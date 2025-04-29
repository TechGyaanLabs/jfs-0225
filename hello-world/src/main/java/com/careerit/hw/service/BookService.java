package com.careerit.hw.service;

import com.careerit.hw.model.Book;

public interface BookService {

    Book addBook(Book book);
    Book getBookById(String id);
    Book updateBook(Book book);
    boolean deleteBook(String id);
    Book getBookByTitle(String title);
}
