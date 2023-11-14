package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements BaseEntityService<Student,StudentDTO> {

    private final Student s = new Student(1L,"bastian","prado","mail@mail.com");

    @Override
    public Student save(StudentDTO studentDTO) {
        return s;
    }

    @Override
    public Student findById(Long id) {
        return s;
    }

    @Override
    public List<Student> findAll() {
        return Collections.singletonList(s);
    }

    @Override
    public void delete(Long id) {
        System.out.println("deleted");
    }

    @Override
    public Student update(Long id, StudentDTO studentDTO) {
        return s;
    }
}
