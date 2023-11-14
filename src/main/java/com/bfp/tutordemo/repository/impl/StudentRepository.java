package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.repository.BaseEntityRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseEntityRepository<Student, StudentDTO> {
    boolean existsByEmail(String email);
}
