package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repsitories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class StudentRestController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students(){
        return studentRepository.findAll();
    }

    @GetMapping("/addstudent")
    public List <Student> addstudent(){
        Student student = new Student();
        student.setName("gustav");
        student.setBornDate(LocalDate.of(1999,6,1));
        student.setBornTime(LocalTime.of(10,20,12));
        studentRepository.save(student);
        return studentRepository.findAll();
    }
    @GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name){
        return studentRepository.findAllByName(name);
    }
/*
    @GetMapping("/students/{bornDate}")
    public List <Student> getAllStudentsByBornDate(@PathVariable LocalDate bornDate){
        return studentRepository.findAllByBornDate(bornDate);
    }
     @GetMapping("/students/{id}")
    public List <Student> deleteStudentByID (@PathVariable int id){
        studentRepository.deleteStudentById(id);
        return studentRepository.findAll();
    }
    */

}
