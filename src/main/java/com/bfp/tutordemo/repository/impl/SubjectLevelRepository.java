package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectLevelRepository extends JpaRepository<SubjectLevel,Long> {
}
