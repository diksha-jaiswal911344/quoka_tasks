package com.Calculator.Calculator.Controller;

import com.Calculator.Calculator.Request.RequestHandeling;
import com.Calculator.Calculator.Response.ResponseHandling;
import com.Calculator.Calculator.Service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class MainController {
    @Autowired
    private ServiceProvider service;

    @PostMapping
    public ResponseHandling calculate (@RequestBody RequestHandeling request){
        return service.performOperation(request);
    }

}