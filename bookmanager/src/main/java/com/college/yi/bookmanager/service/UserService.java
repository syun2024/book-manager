package com.college.yi.bookmanager.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.college.yi.bookmanager.mapper.UserMapper;
import com.college.yi.bookmanager.model.BookUserDetails;
import com.college.yi.bookmanager.model.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserEntity userEnt = userMapper.loadUserByUsername(userName);
        if (Objects.isNull(userEnt)) {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。" + userName);
        }

        return new BookUserDetails(userEnt);

    }

}
