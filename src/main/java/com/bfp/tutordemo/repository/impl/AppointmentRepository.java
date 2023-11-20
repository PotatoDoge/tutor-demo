package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findBySubjectLevel(SubjectLevel subjectLevel);

    List<Appointment> findBySubjectLevelAndStatus(SubjectLevel subjectLevel, String freeAppointment);
}
