package com.careerit.hw.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hw")
public class HelloWorldController {

    @GetMapping("/greetings")
    public String greetings(@RequestParam(defaultValue = "User")String username){
        return "Hello " + username + ", welcome to spring boot world!";
    }
}
