package com.college.yi.bookmanager.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookEntity {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    private Integer stock;
}