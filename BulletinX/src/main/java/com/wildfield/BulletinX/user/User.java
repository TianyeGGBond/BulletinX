package com.wildfield.BulletinX.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private LocalDate birth;

    public User(Integer id, String name, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
