package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectLevelRepository extends JpaRepository<SubjectLevel,Long> {

    public boolean existsBySubjectAndLevel(Subject subject, Level level);

    SubjectLevel findBySubjectAndLevel(Subject subject, Level level);

}
