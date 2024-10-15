package com.example.student.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(name = "/get")
    String getDemo() {
        return "Hello friend";
    }
}
