package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.dto.TutorDTO;
import com.bfp.tutordemo.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends BaseEntityRepository<Tutor, TutorDTO> {

    boolean existsByEmail(String email);

}
