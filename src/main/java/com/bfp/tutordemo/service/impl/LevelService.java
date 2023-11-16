package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.dto.LevelDTO;
import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.repository.impl.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level save(LevelDTO levelDTO){
        Level level = new Level(null, levelDTO.getName());
        return levelRepository.save(level);
    }

    public Optional<Level> findById(Long id){
        return levelRepository.findById(id);
    }

    public List<Level> findAll(){
        return levelRepository.findAll();
    }

    public void delete(Long id){
        levelRepository.deleteById(id);
        System.out.println("deleted");
    }

    public Level update(Long id, LevelDTO levelDTO){
        Level level = new Level(id, levelDTO.getName());
        return levelRepository.save(level);
    }

}
