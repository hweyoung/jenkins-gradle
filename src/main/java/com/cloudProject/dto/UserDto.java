package com.cloudProject.dto;

import com.cloudProject.domain.user.User;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String pwd;

    public User toEntity(){
          return User.builder()
                  .id(id).pwd(pwd).build();
    }
}
