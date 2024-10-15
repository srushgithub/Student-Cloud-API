package com.example.student.api;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping(value = "/save-student")
    ResponseEntity<Student> saveStudent(@RequestBody @Valid final Student student) {
        final Student responseStudent = studentService.saveStudent(student);

        return new ResponseEntity<>(responseStudent, HttpStatus.OK);
    }

    @GetMapping(value = "/get-student-details/{id}")
    ResponseEntity<Student> getStudentDetails(@PathVariable Integer id) {
        final Student student = studentService.getStudentDetails(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/get-student-profile-picture/{id}")
    ResponseEntity<byte[]> getStudentPicture(@PathVariable Integer id) {
        final byte[] imageBytes = studentService.getProfilePicture(id);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
