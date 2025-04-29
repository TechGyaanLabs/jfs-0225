package com.careerit.hw.api;

import com.careerit.hw.model.Book;
import com.careerit.hw.service.BookService;
import com.careerit.hw.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public Book getBookByTitle(@RequestParam(defaultValue = "") String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }
}
