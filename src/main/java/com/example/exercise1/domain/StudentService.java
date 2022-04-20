package com.example.exercise1.domain;

import com.example.exercise1.domain.model.Student;
import com.example.exercise1.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
}
