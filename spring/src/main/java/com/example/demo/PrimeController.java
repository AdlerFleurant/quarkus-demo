package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {
    @GetMapping("/hello-spring/{input}")
    public Payload one(@PathVariable long input) {

        return Payload.generate(input);
    }
}
