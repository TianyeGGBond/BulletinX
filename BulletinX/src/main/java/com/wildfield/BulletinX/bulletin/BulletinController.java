package com.wildfield.BulletinX.bulletin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class BulletinController {
    @RequestMapping(method = RequestMethod.GET, path = "/bulletin")
   public String bulletin(){
       return "Hello World";
   }
}
