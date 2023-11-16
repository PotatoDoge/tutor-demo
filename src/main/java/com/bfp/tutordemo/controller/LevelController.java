package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.LevelDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.LevelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("levels")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LevelController {

    private final LevelService levelService;

    @GetMapping
    public HttpResponse getLevels(){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("Levels",levelService.findAll()))
                .message("Levels retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
    @GetMapping("{id}")
    public HttpResponse getLevelById(@PathVariable("id") Long id){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.findById(id)))
                .message("Level retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping
    public HttpResponse createLevel(@Valid @RequestBody LevelDTO level){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.save(level)))
                .message("Level created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateLevel(@PathVariable("id")Long id, @Valid @RequestBody LevelDTO level){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.update(id,level)))
                .message("Level updated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteLevelById(@PathVariable("id")Long id){
        levelService.delete(id);
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Level deleted!")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }
}
