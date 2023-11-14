package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.TutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public HttpResponse getTutors(){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutors",tutorService.findAll()))
                .message("Tutors retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
    @GetMapping("{id}")
    public HttpResponse getTutorById(@PathVariable("id") Long id){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.findById(id)))
                .message("Tutor retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping
    public HttpResponse createTutor(@Valid @RequestBody TutorDTO tutorDTO){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.save(tutorDTO)))
                .message("Tutor created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateTutor(@PathVariable("id")Long id, @Valid @RequestBody TutorDTO tutorDTO){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutor",tutorService.update(id,tutorDTO)))
                .message("Tutor updated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteTutorById(@PathVariable("id")Long id){
        tutorService.delete(id);
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Tutors deleted!")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }

}
