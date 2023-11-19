package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.SubjectLevelRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;

import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectLevelService {

    private final SubjectLevelRepository subjectLevelRepository;

    public SubjectLevel associateSubjectToLevel(Subject subject, Level level){

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

}
