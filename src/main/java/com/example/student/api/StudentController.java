package com.example.student.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(value = "/get")
    String getDemo() {
        return "Hello friend";
    }

    @GetMapping(value = "/test")
    String getTest() {
        return "pass";
    }
}
