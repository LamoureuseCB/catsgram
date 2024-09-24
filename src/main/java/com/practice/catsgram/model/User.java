package com.practice.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;


    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }


}
