package com.college.yi.bookmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.college.yi.bookmanager.model.entity.BookEntity;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM books")
    List<BookEntity> findAll();

    @Insert({ "INSERT INTO books(title, author, publisher, published_date, stock)",
            "VALUES(#{title}, #{author}, #{publisher}, #{publishedDate}, #{stock})" })
    int insert(BookEntity book);

    @Update({ "UPDATE books",
            "SET title = #{title}, author = #{author}, publisher = #{publisher}, published_date = #{publishedDate}, stock = #{stock}",
            "WHERE id = #{id}" })
    int update(BookEntity book);

    @Delete({ "DELETE FROM books", "WHERE id = #{id}" })
    int delete(int id);
}
