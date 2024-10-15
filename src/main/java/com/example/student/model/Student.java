package com.example.student.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student implements Serializable {

    @Id
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String score;

    @Setter
    @NotNull
    @Column(name = "profile_picture")
    private String profilePicture;
}
