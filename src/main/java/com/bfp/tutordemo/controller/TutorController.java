package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.TutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("tutors")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TutorController {

    private final TutorService tutorService;

    @GetMapping
    public ResponseEntity<HttpResponse> getTutors(){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutors",tutorService.findAll()))
                .message("Tutors retrieved!")
                .build());
    }
    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> getTutorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.findById(id)))
                .message("Tutor retrieved!")
                .build());
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createTutor(@Valid @RequestBody TutorDTO tutorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.save(tutorDTO)))
                .message("Tutor created!")
                .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> updateTutor(@PathVariable("id")Long id, @Valid @RequestBody TutorDTO tutorDTO){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.update(id,tutorDTO)))
                .message("Tutor updated!")
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse> deleteTutorById(@PathVariable("id")Long id){
        tutorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Tutors deleted!")
                .build());
    }
}
