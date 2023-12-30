package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.StudentService;
import jakarta.validation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("students")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<HttpResponse> getStudents(){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("students",studentService.findAll()))
                .message("Students retrieved!")
                .build());

    }
    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.findById(id)))
                .message("Student retrieved!")
                .build());
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createStudent(@Valid @RequestBody StudentDTO student){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.save(student)))
                .message("Student created!")
                .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> updateStudent(@PathVariable("id")Long id, @Valid @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.update(id,studentDTO)))
                .message("Student updated!")
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse> deleteStudentById(@PathVariable("id")Long id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Student deleted!")
                .build());
    }
}
