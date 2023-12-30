package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.LevelDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.LevelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("levels")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class LevelController {

    private final LevelService levelService;

    @GetMapping
    public ResponseEntity<HttpResponse> getLevels(){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("Levels",levelService.findAll()))
                .message("Levels retrieved!")
                .build());
    }
    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> getLevelById(@PathVariable("id") Long id){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.findById(id)))
                .message("Level retrieved!")
                .build());
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createLevel(@Valid @RequestBody LevelDTO level){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.save(level)))
                .message("Level created!")
                .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> updateLevel(@PathVariable("id")Long id, @Valid @RequestBody LevelDTO level){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("level",levelService.update(id,level)))
                .message("Level updated!")
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse> deleteLevelById(@PathVariable("id")Long id){
        levelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Level deleted!")
                .build());
    }
}
