package com.example.demo.repsitories;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOnKarl(){
        List<Student> studentList = studentRepository.findAllByName("Karl");
        assertEquals(1,studentList.size());
    }

    @Test
    void TestOneViggo(){
        Student student = new Student();
        student.setName("Caroline");
        student.setBornDate(LocalDate.of(2010,11,7));
        studentRepository.save(student);
        List<Student> studentList = studentRepository.findAllByName("Caroline");
        assertEquals(1,studentList.size());
    }

    @Test
    void numberOfStudents(){
        int actual = studentRepository.findAll().size();
        int expected = 11;
        assertEquals(actual,expected);
    }

    /*@Test
    void deleteStudent(){
        studentRepository.deleteStudentById(1);
        int actual = studentRepository.findAll().size();
        int expected = 10;
        assertEquals(actual,expected);
    }
*/
    @Test
    void findByBirthdate(){
    }


}