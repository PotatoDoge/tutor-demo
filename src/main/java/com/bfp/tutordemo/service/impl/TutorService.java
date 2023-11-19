package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.repository.impl.TutorRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import com.bfp.tutordemo.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TutorService implements BaseEntityService<Tutor, TutorDTO> {

    private final TutorRepository tutorRepository;

    @Override
    public Tutor save(TutorDTO tutorDTO) {
        Tutor tutor = new Tutor(null,tutorDTO.getFirstName(), tutorDTO.getLastName(), tutorDTO.getEmail());
        boolean emailExistsInDatabase = tutorRepository.existsByEmail(tutor.getEmail());
        if(emailExistsInDatabase){
            log.info("Email {} already in database", tutorDTO.getEmail());
            throw new ValueExistsInDatabase("Email already registered!");
        }
        Tutor savedtutor = tutorRepository.save(tutor);
        log.info("Tutor saved with ID:{}", savedtutor.getId());
        return savedtutor;
    }

    @Override
    public Tutor findById(Long id) {
        Tutor foundtutor = tutorRepository.findById(id).orElse(null);
        if(foundtutor == null){
            log.info("Tutor with ID:{} was not found",id);
            throw new NotFoundInDatabase("Tutor with the given ID was not found in database");
        }
        log.info("Tutor with ID:{} was found",id);
        return foundtutor;
    }

    @Override
    public List<Tutor> findAll() {
        List<Tutor> foundTutors = tutorRepository.findAll();
        if(foundTutors.isEmpty()){
            log.info("There were no tutors found in database");
            return foundTutors;
        }
        log.info("Tutors retrieved successfully");
        return foundTutors;
    }

    @Override
    public void delete(Long id) {
        Tutor tutor = findById(id);
        if(tutor == null){
            log.info("Tutor with ID:{} was not found",id);
            return;
        }
        tutorRepository.deleteById(id);
        log.info("Tutor with ID:{} was deleted successfully",id);
    }

    @Override
    public Tutor update(Long id, TutorDTO tutorDTO) {
        Tutor tutorInDatabase = findById(id);
        tutorInDatabase.setFirstName(tutorDTO.getFirstName());
        tutorInDatabase.setLastName(tutorDTO.getLastName());
        tutorInDatabase.setEmail(tutorDTO.getEmail());

        Tutor updatedTutor = tutorRepository.save(tutorInDatabase);
        log.info("Tutor with ID:{} was updated successfully",id);
        return updatedTutor;
    }

}
