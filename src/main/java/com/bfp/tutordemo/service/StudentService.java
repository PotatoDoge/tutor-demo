package com.bfp.tutordemo.service;

import com.bfp.tutordemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(Long id);

    Student saveStudent();

    Student updateStudent(Long id);

    Student deleteStudent(Long id);

}
