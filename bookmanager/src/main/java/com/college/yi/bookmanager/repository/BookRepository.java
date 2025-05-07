package com.college.yi.bookmanager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.college.yi.bookmanager.mapper.BookMapper;
import com.college.yi.bookmanager.model.entity.BookEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final BookMapper bookMapper;

    public List<BookEntity> findAll() {
        return bookMapper.findAll();
    }

    public int insert(BookEntity book) {
        return bookMapper.insert(book);
    }

    public int update(BookEntity book) {
        return bookMapper.update(book);
    }

    public int delete(int id) {
        return bookMapper.delete(id);
    }

}
