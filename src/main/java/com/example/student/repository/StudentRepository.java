package com.example.student.repository;

import com.example.student.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT st FROM Student st WHERE id = :id")
    Student getStudentDetails(final Integer id);

    @Query("SELECT profilePicture FROM Student WHERE id = :id")
    String getProfilePicture(final Integer id);
}
