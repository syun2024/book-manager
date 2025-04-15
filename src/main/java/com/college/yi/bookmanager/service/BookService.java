package com.college.yi.bookmanager.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.college.yi.bookmanager.entity.BookEntity;
import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.repository.BookRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

public List<Book> getAllBooks() {
        List<BookEntity> entities = bookRepository.findAll();
        if (entities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "書籍が見つかりません");
        }
        return entities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    public Book createBook(Book model) {
        BookEntity entity = convertToEntity(model);
        bookRepository.insert(entity);
        model.setId(entity.getId());
        return model;
    }

    public Book updateBook(Long id, Book model) {
        BookEntity entity = convertToEntity(model);
        entity.setId(id);
        bookRepository.update(entity);
        return model;
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

    private Book convertToModel(BookEntity entity) {
        Book model = new Book();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setAuthor(entity.getAuthor());
        model.setPublisher(entity.getPublisher());
        model.setPublishedDate(entity.getPublishedDate());
        model.setStock(entity.getStock());
        return model;
    }

    private BookEntity convertToEntity(Book model) {
        BookEntity entity = new BookEntity();
        entity.setTitle(model.getTitle());
        entity.setAuthor(model.getAuthor());
        entity.setPublisher(model.getPublisher());
        entity.setPublishedDate(model.getPublishedDate());
        entity.setStock(model.getStock());
        return entity;
    }
}
