package com.college.yi.bookmanager.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    
    private int id;
    
    private String title;
    
    private String author;
    
    private String publisher;
    
    private LocalDate publishedDate;
    
    private int stock;
    
    public Book(int id,String title,String author,String publisher,LocalDate publishedDate,int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.stock = stock;
    }
}