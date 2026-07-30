package com.yannttb.bookapi.service;

import com.yannttb.bookapi.model.Book;
import com.yannttb.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}