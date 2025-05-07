package com.college.yi.bookmanager.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    
    private int id;
    
    private String userName;
    
    private String password;
    
    private String role;
    
    private Boolean enabled;
    
}
