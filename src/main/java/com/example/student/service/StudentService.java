package com.example.student.service;

import com.example.student.exception.AppException;
import com.example.student.exception.ProfilePicException;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ObjectMapper objectMapper;
    private final StudentRepository studentRepository;

    public Student saveStudent(final Student student) {

        return studentRepository.save(student);
    }

    public Student getStudentDetails(final Integer id) {
        final Student student = studentRepository.getStudentDetails(id);
        student.setProfilePicture(null);

        return student;
    }

    public byte[] getProfilePicture(final Integer id) {
        final String imageUrl = studentRepository.getProfilePicture(id);

        try {
            final URL url = new URL(imageUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            final InputStream inputStream = connection.getInputStream();

            // Read image as byte array
            final byte[] imageBytes = inputStream.readAllBytes();
            inputStream.close();

            return imageBytes;
        } catch (IOException ex) {
            throw new ProfilePicException(ex.getMessage());
        }
    }
}
