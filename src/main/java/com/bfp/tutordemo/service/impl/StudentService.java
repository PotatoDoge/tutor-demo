package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.repository.impl.StudentRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import com.bfp.tutordemo.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements BaseEntityService<Student,StudentDTO> {

    private final StudentRepository studentRepository;

    @Override
    public Student save(StudentDTO studentDTO) {
        Student student = new Student(null,studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
        boolean emailExistsInDatabase = studentRepository.existsByEmail(student.getEmail());
        if(emailExistsInDatabase){
            log.info("Email {} already in database", studentDTO.getEmail());
            throw new ValueExistsInDatabase("Email already registered!");
        }
        Student savedStudent = studentRepository.save(student);
        log.info("Student saved with ID:{}", savedStudent.getId());
        return savedStudent;
    }

    @Override
    public Student findById(Long id) {
        Student foundStudent = studentRepository.findById(id).orElse(null);
        if(foundStudent == null){
            log.info("Student with ID:{} was not found",id);
            throw new NotFoundInDatabase("Student with the given ID was not found in database");
        }
        log.info("Student with ID:{} was found",id);
        return foundStudent;
    }

    @Override
    public List<Student> findAll() {
        List<Student> foundStudents = studentRepository.findAll();
        if(foundStudents.isEmpty()){
            log.info("There were no students found in database");
            return foundStudents;
        }
        log.info("Students retrieved successfully");
        return foundStudents;
    }

    @Override
    public void delete(Long id) {
        Student student = findById(id);
        if(student == null){
            log.info("Student with ID:{} was not found",id);
            return;
        }
        studentRepository.deleteById(id);
        log.info("Student with ID:{} was deleted successfully",id);
    }

    @Override
    public Student update(Long id, StudentDTO studentDTO) {
        Student studentInDatabase = findById(id);
        studentInDatabase.setFirstName(studentDTO.getFirstName());
        studentInDatabase.setLastName(studentDTO.getLastName());
        studentInDatabase.setEmail(studentDTO.getEmail());

        Student updatedStudent = studentRepository.save(studentInDatabase);
        log.info("Student with ID:{} was updated successfully",id);
        return updatedStudent;
    }
}
