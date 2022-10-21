package com.tms.service.impl;

import com.tms.model.Book;
import com.tms.model.BookProjection;
import com.tms.repository.BookRepository;
import com.tms.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }

    @Override
    public List<BookProjection> findAllBooksWithCount() {
        return bookRepository.findAllBooksWithCount();
    }

    @Override
    public List<Book> showOverdueBooks() {
        return bookRepository
                .showOverdueBooks();
    }

    @Override
    public List<BookProjection> findByAuthorOrderByTitle(String author) {
        return bookRepository.findByAuthorOrderByTitle(author);
    }
}
