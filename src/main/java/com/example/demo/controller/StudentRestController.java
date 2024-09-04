package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repsitories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student){
        System.out.println(student);
        return studentRepository.save(student);
    }

@PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> orgStudent = studentRepository.findById(id);
            if (orgStudent.isPresent()){
                 studentRepository.save(student);
                 return ResponseEntity.ok(student);
    } else{
                return ResponseEntity.notFound().build();
            }
    }





    @GetMapping("/students/{name}")
    public ResponseEntity<List> getAllStudentsByName(@PathVariable String name){
        List<Student> studentsList = studentRepository.findAllByName(name);
        if (!studentsList.isEmpty()){
            return  ResponseEntity.ok(studentsList);
        } else
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/studentsID/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()){
            return ResponseEntity.ok(orgStudent.get());
        }else
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

    }


}
