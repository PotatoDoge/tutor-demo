package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
