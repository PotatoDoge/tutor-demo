package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.repository.impl.TutorRepository;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import com.bfp.tutordemo.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorService implements BaseEntityService<Tutor, TutorDTO> {

    private final TutorRepository tutorRepository;

    @Override
    public Tutor save(TutorDTO tutorDTO) {
        Tutor tutor = new Tutor(null,tutorDTO.getFirstName(), tutorDTO.getLastName(), tutorDTO.getEmail());
        boolean emailExistsInDatabase = tutorRepository.existsByEmail(tutor.getEmail());
        if(emailExistsInDatabase){
            throw new ValueExistsInDatabase("Email already registered!");
        }
        return tutorRepository.save(tutor);
    }

    @Override
    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id);
    }

    @Override
    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        tutorRepository.deleteById(id);
        System.out.println("Tutor deleted!");
    }

    @Override
    public Tutor update(Long id, TutorDTO tutorDTO) {
        Tutor tutor = new Tutor(id, tutorDTO.getFirstName(), tutorDTO.getLastName(), tutorDTO.getEmail());
        return tutorRepository.save(tutor) ;
    }
}
