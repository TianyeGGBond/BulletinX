package com.wildfield.BulletinX.bulletin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class BulletinController {
    @GetMapping( path = "/bulletin")
   public BulletinBean bulletinBean(){
//        bean输出会自动转化为json
//        Spring Boot 会自动配置一个叫做 HttpMessageConverter 的组件。
//        这个组件会帮你把 Java 对象（Bean）自动转换成 JSON。
        return new BulletinBean ("Hello World");
   }
   @GetMapping(path = "/bulletin/{name}")
   //@PathVariable 让spring开始识别路径变量
    public BulletinBean bulletinGreeting(@PathVariable String name){
        return new BulletinBean(String.format("Hello, " + name));
   }

}
