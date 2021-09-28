package com.noahmlr.docker.samples.jdk17;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Message greetUser(@RequestParam(name = "name", defaultValue = "Noah") String name) {
        return new Message(name);
    }

    @GetMapping("/pattern")
    public Message previewFeature(@RequestParam(name = "number", defaultValue = "1") int number) {
        var record = new Number(number);
        return switch (record) {
            case Number n && n.number() > 0 -> new Message("Above Zero");
            case Number n && n.number() < 0 -> new Message("Below Zero");
            case Number n -> new Message("Zero");
        };
    }

    public record Message(String content) {}

    public record Number(int number) {}
}
