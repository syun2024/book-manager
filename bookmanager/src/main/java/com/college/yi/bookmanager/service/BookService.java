package com.college.yi.bookmanager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.college.yi.bookmanager.model.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "本１", "筆者１", "出版社１", LocalDate.now(),100));
        bookList.add(new Book(2, "本２", "筆者２", "出版社２", LocalDate.now(),200));
        bookList.add(new Book(3, "本３", "筆者３", "出版社３", LocalDate.now(),300));
        bookList.add(new Book(4, "本４", "筆者４", "出版社４", LocalDate.now(),400));
        bookList.add(new Book(5, "本５", "筆者５", "出版社５", LocalDate.now(),500));
        
        return bookList;
    }
    
    
}
