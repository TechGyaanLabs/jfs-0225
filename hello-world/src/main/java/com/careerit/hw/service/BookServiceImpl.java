package com.careerit.hw.service;

import com.careerit.hw.exception.BookNotFoundException;
import com.careerit.hw.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    private List<Book> books = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        UUID id = UUID.randomUUID();
        book.setId(id);
        books.add(book);
        log.info("Book added with id: {},title: {} and total books: {}", id, book.getTitle(), books.size());
        return book;
    }

    @Override
    public Book getBookById(String id) {
        if(id == null || id.isEmpty()){
            throw new BookNotFoundException("Book id is null or empty");
        }else{
            for (Book book : books) {
                if (book.getId().toString().equals(id)) {
                    return book;
                }
            }
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public Book updateBook(Book book) {
        if(book == null || book.getId() == null){
            throw new BookNotFoundException("Book id is null or empty");
        }else{
            for (Book b : books) {
                if (b.getId().equals(book.getId())) {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setPrice(book.getPrice());
                    return b;
                }
            }
            throw new BookNotFoundException("Book not found with id: " + book.getId());
        }
    }

    @Override
    public boolean deleteBook(String id) {
        if (id == null || id.isEmpty()) {
            throw new BookNotFoundException("Book id is null or empty");
        } else {
            for (Book book : books) {
                if (book.getId().toString().equals(id)) {
                    books.remove(book);
                    log.info("Book deleted with id: {}, title: {} and total books: {}", id, book.getTitle(), books.size());
                    return true;
                }
            }
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new BookNotFoundException("Book title is null or empty");
        }else{
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            throw new BookNotFoundException("Book not found with title: " + title);
        }
    }
}
