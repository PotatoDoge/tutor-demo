package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.entity.dto.SubjectLevelDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.SubjectLevelRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;

import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectLevelService {

    private final SubjectLevelRepository subjectLevelRepository;
    private final SubjectService subjectService;
    private final LevelService levelService;


    public SubjectLevel associateSubjectToLevel(Long subjectId, Long levelId){

        Subject subject = subjectService.findById(subjectId);
        Level level = levelService.findById(levelId);

        boolean combinationExists = subjectLevelRepository.existsBySubjectAndLevel(
                subject, level);

        if(combinationExists){
            throw new ValueExistsInDatabase("That subject and level combination already exists in database.");
        }

        if(subject == null || level == null){
            throw new NotFoundInDatabase("Either subject or level were not found in database");
        }
        SubjectLevel subjectLevel = new SubjectLevel(null, subject,level);
        return subjectLevelRepository.save(subjectLevel);
    }
    public Optional<SubjectLevel> findById(Long id){
        return subjectLevelRepository.findById(id);
    }

    public SubjectLevel findBySubjectAndLevel(String subjectName, String levelName){
        Subject subject = subjectService.findByName(subjectName);
        Level level = levelService.findByName(levelName);
        return subjectLevelRepository.findBySubjectAndLevel(subject,level);
    }

    public List<SubjectLevelDTO> findAllSubjectLevelPairs(){
        return subjectLevelRepository.findAllSubjectLevelPairs();
    }

}
