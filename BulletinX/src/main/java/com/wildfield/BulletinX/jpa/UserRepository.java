package com.wildfield.BulletinX.jpa;

import com.wildfield.BulletinX.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
