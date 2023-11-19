package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.SubjectLevelService;
import com.bfp.tutordemo.service.impl.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("subjects")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectLevelService subjectLevelService;

    @GetMapping
    public HttpResponse getSubjects(){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subjects",subjectService.findAll()))
                .message("Subjects retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
    @GetMapping("{id}")
    public HttpResponse getSubjectById(@PathVariable("id") Long id){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.findById(id)))
                .message("Subject retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping
    public HttpResponse createSubject(@Valid @RequestBody SubjectDTO subject){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.save(subject)))
                .message("Subject created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateSubject(@PathVariable("id")Long id, @Valid @RequestBody SubjectDTO subject){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subject",subjectService.update(id,subject)))
                .message("Subject updated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteSubjectById(@PathVariable("id")Long id){
        subjectService.delete(id);
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Subject deleted!")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }

    @PostMapping("{subjectId}/levels/{levelId}")
    public HttpResponse associateSubjectToLevel(@PathVariable("subjectId")Long subjectId, @PathVariable("levelId") Long levelId){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("subjectLevel",subjectLevelService.associateSubjectToLevel(subjectId,levelId)))
                .message("Subject and level associated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

}
