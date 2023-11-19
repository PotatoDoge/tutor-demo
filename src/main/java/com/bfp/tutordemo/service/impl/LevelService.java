package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.dto.LevelDTO;
import com.bfp.tutordemo.repository.impl.LevelRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LevelService {

    private final LevelRepository levelRepository;


    public Level save(LevelDTO levelDTO) {
        Level level = new Level(null, levelDTO.getName());
        Level savedLevel = levelRepository.save(level);
        log.info("Level saved with ID:{}", savedLevel.getId());
        return savedLevel;
    }

    public Level findById(Long id) {
        Level foundLevel = levelRepository.findById(id).orElse(null);
        if(foundLevel == null){
            log.info("Level with ID:{} was not found",id);
            throw new NotFoundInDatabase("Level with the given ID was not found in database");
        }
        log.info("Level with ID:{} was found",id);
        return foundLevel;
    }

    public List<Level> findAll() {
        List<Level> foundLevels = levelRepository.findAll();
        if(foundLevels.isEmpty()){
            log.info("There were no levels found in database");
            return foundLevels;
        }
        log.info("Levels retrieved successfully");
        return foundLevels;
    }

    public void delete(Long id) {
        Level level = findById(id);
        if(level == null){
            log.info("Level with ID:{} was not found",id);
            return;
        }
        levelRepository.deleteById(id);
        log.info("Level with ID:{} was deleted successfully",id);
    }

    public Level update(Long id, LevelDTO levelDTO) {
        Level levelInDatabase = findById(id);
        levelInDatabase.setName(levelDTO.getName());
        Level updatedLevel = levelRepository.save(levelInDatabase);
        log.info("Level with ID:{} was updated successfully",id);
        return updatedLevel;
    }

    public Level findByName(String levelName) {
        return levelRepository.findByName(levelName);
    }
}
