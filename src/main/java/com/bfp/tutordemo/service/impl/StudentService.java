package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.repository.impl.StudentRepository;
import com.bfp.tutordemo.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseEntityService<Student,StudentDTO> {

    private final StudentRepository studentRepository;

    private final Student s = new Student(1L,"bastian","prado","mail@mail.com");

    @Override
    public Student save(StudentDTO studentDTO) {
        Student student = new Student(null,studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
        System.out.println("deleted");
    }

    @Override
    public Student update(Long id, StudentDTO studentDTO) {
        Student student = new Student(id,studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
        return studentRepository.save(student);
    }
}
