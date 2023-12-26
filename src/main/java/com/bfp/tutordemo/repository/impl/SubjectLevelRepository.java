package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.dto.SubjectLevelDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SubjectLevelRepository extends JpaRepository<SubjectLevel,Long> {

    public boolean existsBySubjectAndLevel(Subject subject, Level level);

    SubjectLevel findBySubjectAndLevel(Subject subject, Level level);

    @Query("SELECT NEW com.bfp.tutordemo.entity.dto.SubjectLevelDTO(s.name, l.name) FROM SubjectLevel sl JOIN sl.subject s JOIN sl.level l")
    List<SubjectLevelDTO> findAllSubjectLevelPairs();

}
