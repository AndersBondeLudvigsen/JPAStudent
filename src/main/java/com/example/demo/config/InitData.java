package com.example.demo.config;

import com.example.demo.model.Student;
import com.example.demo.repsitories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class InitData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Karl");
        s1.setBornDate(LocalDate.of(1999,6,1));
        s1.setBornTime(LocalTime.of(10,20,12));
        studentRepository.save(s1);
        studentRepository.save(new Student("Anna", LocalDate.of(2001, 5, 15), LocalTime.of(10, 30, 45)));
        studentRepository.save(new Student("Bjorn", LocalDate.of(2000, 11, 23), LocalTime.of(14, 45, 30)));
        studentRepository.save(new Student("Clara", LocalDate.of(2002, 3, 30), LocalTime.of(8, 15, 20)));
        studentRepository.save(new Student("David", LocalDate.of(2001, 7, 10), LocalTime.of(12, 0, 10)));
        studentRepository.save(new Student("Emilie", LocalDate.of(2000, 12, 2), LocalTime.of(9, 45, 55)));
        studentRepository.save(new Student("Frederik", LocalDate.of(2001, 8, 19), LocalTime.of(16, 20, 35)));
        studentRepository.save(new Student("Gustav", LocalDate.of(2002, 2, 5), LocalTime.of(11, 0, 5)));
        studentRepository.save(new Student("Helene", LocalDate.of(2000, 10, 1), LocalTime.of(7, 30, 50)));
        studentRepository.save(new Student("Iben", LocalDate.of(2001, 9, 25), LocalTime.of(13, 50, 40)));
        studentRepository.save(new Student("Jonas", LocalDate.of(2002, 4, 12), LocalTime.of(6, 25, 15)));
    }
}
