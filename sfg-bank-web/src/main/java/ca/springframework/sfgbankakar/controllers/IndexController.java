package ca.springframework.sfgbankakar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController method tarafında ki string değeri bile dönerken @controller dönmüyor thymeleaf göre -> resources/templates directory dönüyor
@RestController
public class IndexController {

    //Mapping de belirtilen türlere göre request atılır
    @GetMapping({"","/","index","/index.html"})
    public String index(){
        return "WELCOME INDEX PAGE";
    }
}
