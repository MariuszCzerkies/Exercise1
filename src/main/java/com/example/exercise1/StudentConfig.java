package com.example.exercise1;

import com.example.exercise1.domain.model.Student;
import com.example.exercise1.domain.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.NOVEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mario = new Student(
                    1L,
                    "Mario",
                    "mario@gmail.com",
                    LocalDate.of(2000, NOVEMBER, 27)
            );
            Student alex = new Student(
                    2L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, NOVEMBER, 12)
            );
            Student xavier = new Student(
                    3L,
                    "Xavier",
                    "xavier@gmail.com",
                    LocalDate.of(2010, DECEMBER, 7)
            );
            repository.saveAll(
                    List.of(mario, alex, xavier)
            );
        };
    }
}
