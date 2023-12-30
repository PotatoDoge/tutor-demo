package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.SubjectLevelService;
import com.bfp.tutordemo.service.impl.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("subjects")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectLevelService subjectLevelService;

    @GetMapping
    public ResponseEntity<HttpResponse> getSubjects(){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subjects",subjectService.findAll()))
                .message("Subjects retrieved!")
                .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> getSubjectById(@PathVariable("id") Long id){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.findById(id)))
                .message("Subject retrieved!")
                .build());
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createSubject(@Valid @RequestBody SubjectDTO subject){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.save(subject)))
                .message("Subject created!")
                .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> updateSubject(@PathVariable("id")Long id, @Valid @RequestBody SubjectDTO subject){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.update(id,subject)))
                .message("Subject updated!")
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse> deleteSubjectById(@PathVariable("id")Long id){
        subjectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Subject deleted!")
                .build());
    }

    @PostMapping("{subjectId}/levels/{levelId}")
    public ResponseEntity<HttpResponse> associateSubjectToLevel(@PathVariable("subjectId")Long subjectId, @PathVariable("levelId") Long levelId){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subjectLevel",subjectLevelService.associateSubjectToLevel(subjectId,levelId)))
                .message("Subject and level associated!")
                .build());
    }

    @GetMapping("level")
    public ResponseEntity<HttpResponse> getSubjectLevelValues(){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subjectLevels",subjectLevelService.findAllSubjectLevelPairs()))
                .message("SubjectLevels retrieved!")
                .build());
    }

}
