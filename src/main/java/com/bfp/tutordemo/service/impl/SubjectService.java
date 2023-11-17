package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectLevelService subjectLevelService;
    private final LevelService levelService;

    public Subject save(SubjectDTO subjectDTO){
        Subject subject = new Subject(null, subjectDTO.getName(), subjectDTO.getDescription());
        return subjectRepository.save(subject);
    }

    public Optional<Subject> findById(Long id){
        return subjectRepository.findById(id);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public void delete(Long id){
        subjectRepository.deleteById(id);
        System.out.println("deleted");
    }

    public Subject update(Long id, SubjectDTO subjectDTO){
        Subject subject = new Subject(id, subjectDTO.getName(), subjectDTO.getDescription());
        return subjectRepository.save(subject);
    }

    public SubjectLevel associateSubjectToLevel(Long subjectId, Long levelId){
        Subject subject = findById(subjectId).orElse(null);
        Level level = levelService.findById(levelId).orElse(null);
        return subjectLevelService.associateSubjectToLevel(subject,level);
    }

}
