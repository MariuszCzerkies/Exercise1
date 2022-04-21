package com.example.exercise1.controller.dto;

import com.example.exercise1.domain.model.Student;
import com.example.exercise1.domain.model.Students;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.NOVEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @DisplayName("GET - get All Student -> HTTP 200")
    void shouldGetAllStudent() throws Exception {
        //given
        List<Student> expectedList = List.of(
                new Student(1l, "Mario", "mario@gmail.com", LocalDate.of(2000, NOVEMBER, 27)),
                new Student(2L, "Alex", "alex@gmail.com", LocalDate.of(2004, NOVEMBER, 12)),
                new Student(3L, "Xavier", "xavier@gmail.com", LocalDate.of(2010, DECEMBER, 7))
        );

        //when
        final var responseBodyAsString = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/allStudent"))
                .andDo(print())
                .andExpect(status().isOk());

        final var studentFromDBInJSON = responseBodyAsString.andReturn().getResponse().getContentAsString();
        //Students responseBody = objectMapper.readValue(studentFromDBInJSON, new TypeReference<>() {});
        Students responseBody = objectMapper.readValue(studentFromDBInJSON, Students.class);

        //then
        assertEquals(expectedList.size(), responseBody.getStudentList().size());
    }
}