package com.ilionx.carapp.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("api/helloworld")
public class helloworld {

    @GetMapping
    public String sayHello() {
        return "Hello world!";
    }
}