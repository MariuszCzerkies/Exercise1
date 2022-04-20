package com.example.exercise1.controller.dto;

import com.example.exercise1.domain.StudentService;
import com.example.exercise1.domain.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
}
