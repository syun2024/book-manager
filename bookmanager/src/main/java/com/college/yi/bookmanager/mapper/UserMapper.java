package com.college.yi.bookmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.college.yi.bookmanager.model.entity.UserEntity;

@Mapper
public interface UserMapper {

    List<UserEntity> findAll();

    UserEntity loadUserByUsername(String userName);

}
