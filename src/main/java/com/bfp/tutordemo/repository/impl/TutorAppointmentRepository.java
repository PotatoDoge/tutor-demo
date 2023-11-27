package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.linkingTables.TutorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorAppointmentRepository extends JpaRepository<TutorAppointment,Long> {
}
