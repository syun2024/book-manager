package com.college.yi.bookmanager.service;

import org.springframework.stereotype.Service;

import com.college.yi.bookmanager.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Java入門");
        book1.setAuthor("山田 太郎");
        book1.setPublisher("技術評論社");
        book1.setPublishedDate(LocalDate.of(2020, 1, 15));
        book1.setStock(5);
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Spring Boot実践");
        book2.setAuthor("佐藤 花子");
        book2.setPublisher("翔泳社");
        book2.setPublishedDate(LocalDate.of(2021, 5, 10));
        book2.setStock(3);
        books.add(book2);

        Book book3 = new Book();
        book3.setId(3L);
        book3.setTitle("MyBatis完全ガイド");
        book3.setAuthor("中村 一郎");
        book3.setPublisher("オライリー");
        book3.setPublishedDate(LocalDate.of(2022, 3, 20));
        book3.setStock(2);
        books.add(book3);

        Book book4 = new Book();
        book4.setId(4L);
        book4.setTitle("SQLの絵本");
        book4.setAuthor("田中 美咲");
        book4.setPublisher("インプレス");
        book4.setPublishedDate(LocalDate.of(2019, 7, 25));
        book4.setStock(8);
        books.add(book4);

        Book book5 = new Book();
        book5.setId(5L);
        book5.setTitle("クラウド時代のアーキテクチャ");
        book5.setAuthor("鈴木 健");
        book5.setPublisher("技術評論社");
        book5.setPublishedDate(LocalDate.of(2023, 9, 30));
        book5.setStock(4);
        books.add(book5);

        return books;
    }
}
