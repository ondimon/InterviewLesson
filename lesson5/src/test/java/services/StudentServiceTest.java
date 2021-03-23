package services;

import model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceTest {
    StudentService studentService;

    @BeforeEach
    void init() {
        studentService = StudentService.getInstance();
    }

    @Test
    void get() {
        Student student = studentService.get(1L);
        assertEquals(1L, student.getId());
        assertEquals("test", student.getName());
    }

    @Test
    void saveOrUpdate() {
        Student student = new Student();
        student.setName("test");
        student.setMark(5);
        assertEquals(null, student.getId());
        studentService.saveOrUpdate(student);
        assertNotEquals(null, student.getId());
    }
}