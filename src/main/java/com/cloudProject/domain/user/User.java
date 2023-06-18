package com.cloudProject.domain.user;

import com.cloudProject.domain.global.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Table(name = "user")
@NoArgsConstructor
@Entity
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    private String id;

    private String pwd;

    @Builder
    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
}
