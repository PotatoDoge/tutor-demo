package com.bfp.tutordemo.service;

import com.bfp.tutordemo.entity.BaseEntity;

public interface BaseEntityService <T extends BaseEntity, D> {

    T save(D entity);

    T findById(Long id);

    Iterable<T> findAll();

    void delete(Long id);

    T update(Long id, D entity);

}
