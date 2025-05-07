package com.college.yi.bookmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookApiController {

    public final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBookApi() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book book) {
        Book created = bookService.create(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable int id) {
        Book updated = bookService.update(book, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
