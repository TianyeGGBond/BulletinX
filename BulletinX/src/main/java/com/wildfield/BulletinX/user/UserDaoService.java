package com.wildfield.BulletinX.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    //全类共享static
    private static int usersCount = 0;

    static{
        users.add(new User(++usersCount,"doll", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"toy", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"visa", LocalDate.now().minusYears(20)));
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }


    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        //根据id筛选，返回第一个
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
