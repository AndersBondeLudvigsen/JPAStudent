package com.example.demo.repsitories;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name);

   /* List<Student> findAllByBornDate(LocalDate bornDate);

    List<Student> deleteStudentById(int id);

    */
}

