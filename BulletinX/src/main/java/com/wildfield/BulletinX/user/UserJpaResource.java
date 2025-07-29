package com.wildfield.BulletinX.user;

import com.wildfield.BulletinX.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private final UserDaoService service;

    private UserRepository repository;

    //你虽然写了 @Autowired private UserDaoService service;，但是 IDE 发现你没有手动给 service 赋值，它就担心你这个字段会是 null。
    //你可以 使用构造函数注入 来消除这个警告，让代码更明确：
    @Autowired
    public UserJpaResource(UserDaoService service, UserRepository repository){
        this.service = service;
        this.repository = repository;

    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        //new service.findOne(id);
        //这是非法的 Java 语法。不能在方法调用前加 new，应该是直接调用方法。
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    //valid 校验
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);

        // 构建 URI，比如 /users/4
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location)  // 设置 HTTP 状态码 201 和 Location 头
                .build();            // 构造出最终完整的 ResponseEntity 对象

    }
}
