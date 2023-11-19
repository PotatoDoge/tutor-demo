package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.dto.SubjectDTO;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.SubjectRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectLevelService subjectLevelService;
    private final LevelService levelService;

    public Subject save(SubjectDTO subjectDTO) {
        Subject subject = new Subject(null, subjectDTO.getName(), subjectDTO.getDescription());
        Subject savedSubject = subjectRepository.save(subject);
        log.info("Subject saved with ID:{}", savedSubject.getId());
        return savedSubject;
    }

    public Subject findById(Long id) {
        Subject foundSubject = subjectRepository.findById(id).orElse(null);
        if(foundSubject == null){
            log.info("Subject with ID:{} was not found",id);
            throw new NotFoundInDatabase("Subject with the given ID was not found in database");
        }
        log.info("Subject with ID:{} was found",id);
        return foundSubject;
    }

    public List<Subject> findAll() {
        List<Subject> foundSubjects = subjectRepository.findAll();
        if(foundSubjects.isEmpty()){
            log.info("There were no subjects found in database");
            return foundSubjects;
        }
        log.info("Subject retrieved successfully");
        return foundSubjects;
    }

    public void delete(Long id) {
        Subject subject = findById(id);
        if(subject == null){
            log.info("Subject with ID:{} was not found",id);
            return;
        }
        subjectRepository.deleteById(id);
        log.info("Subject with ID:{} was deleted successfully",id);
    }

    public Subject update(Long id, SubjectDTO subjectDTO) {
        Subject subjectInDatabase = findById(id);
        subjectInDatabase.setName(subjectDTO.getName());
        subjectInDatabase.setDescription(subjectDTO.getDescription());
        Subject updatedSubject = subjectRepository.save(subjectInDatabase);
        log.info("Subject with ID:{} was updated successfully",id);
        return updatedSubject;
    }

    public SubjectLevel associateSubjectToLevel(Long subjectId, Long levelId){
        Subject subject = findById(subjectId);
        Level level = levelService.findById(levelId);
        return subjectLevelService.associateSubjectToLevel(subject,level);
    }

}
