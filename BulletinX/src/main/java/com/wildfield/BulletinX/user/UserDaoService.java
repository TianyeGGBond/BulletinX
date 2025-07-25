package com.wildfield.BulletinX.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(1,"doll", LocalDate.now().minusYears(30)));
        users.add(new User(2,"toy", LocalDate.now().minusYears(25)));
        users.add(new User(3,"visa", LocalDate.now().minusYears(20)));
    }
    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
