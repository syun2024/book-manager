package com.college.yi.bookmanager.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.college.yi.bookmanager.entity.BookEntity;

@Mapper
public interface BookRepository {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);
    
    void insert(BookEntity book);
    
    void update(BookEntity book);
    
    void delete(Long id);
}