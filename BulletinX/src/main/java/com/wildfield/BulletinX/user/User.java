package com.wildfield.BulletinX.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Birthday should be in the past")
    private LocalDate birth;

//    前端只传 name 和 birth
//    Jackson 用无参构造器创建空对象
//    用 setName() 和 setBirth() 设置值
//    后端自动用 setId(++usersCount) 生成 ID
    public User() {} //无参构造器

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
