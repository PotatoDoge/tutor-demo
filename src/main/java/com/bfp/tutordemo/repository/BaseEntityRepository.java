package com.bfp.tutordemo.repository;


import com.bfp.tutordemo.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository <T extends BaseEntity,D> extends JpaRepository<T,Long> {
}
