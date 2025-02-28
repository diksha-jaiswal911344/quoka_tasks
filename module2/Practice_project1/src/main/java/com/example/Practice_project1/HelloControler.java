package com.example.Practice_project1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloControler {
    @GetMapping("/hello")
    public String GetHello(){
        // return "hello Diksha";
        return "Hello World";
    }
}
