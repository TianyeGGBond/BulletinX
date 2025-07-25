package com.wildfield.BulletinX.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//返回404而不是500
@ResponseStatus( code = HttpStatus.NOT_FOUND)
//extends RuntimeException 创建一种“可以直接报错”的错误类型
//“我不想每次都用 try-catch 来处理它，太麻烦，我只想在出问题时直接报错就好。”
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String message){
        //你只是创建了“自己的错误类型”，但错误逻辑（比如报错时显示什么、怎么处理）是由父类 RuntimeException来实现
        super(message);
    }
}
