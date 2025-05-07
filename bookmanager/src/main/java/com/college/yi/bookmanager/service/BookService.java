package com.college.yi.bookmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.model.entity.BookEntity;
import com.college.yi.bookmanager.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {

        List<BookEntity> bookEntities = bookRepository.findAll();
        if (bookEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < bookEntities.size(); i++) {

            BookEntity bookEnt = bookEntities.get(i);
            Book book = toModel(bookEnt);
            bookList.add(book);
        }

        return bookList;
    }

    public Book create(Book book) {
        BookEntity bookEnt = toEntity(book);
        bookRepository.insert(bookEnt);
        return toModel(bookEnt);
    }

    public Book update(Book book, int id) {
        book.setId(id);
        BookEntity bookEnt = toEntity(book);
        bookRepository.update(bookEnt);
        return toModel(bookEnt);
    }

    public void delete(int id) {
        bookRepository.delete(id);
    }

    private BookEntity toEntity(Book book) {
        BookEntity bookEnt = new BookEntity();
        bookEnt.setId(book.getId());
        bookEnt.setTitle(book.getTitle());
        bookEnt.setAuthor(book.getAuthor());
        bookEnt.setPublisher(book.getPublisher());
        bookEnt.setPublishedDate(book.getPublishedDate());
        bookEnt.setStock(book.getStock());
        return bookEnt;
    }

    private Book toModel(BookEntity bookEnt) {
        return new Book(bookEnt.getId(), bookEnt.getTitle(), bookEnt.getAuthor(), bookEnt.getPublisher(),
                bookEnt.getPublishedDate(), bookEnt.getStock());
    }

}
