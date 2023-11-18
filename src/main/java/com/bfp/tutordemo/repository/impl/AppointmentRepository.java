package com.bfp.tutordemo.repository.impl;

import com.bfp.tutordemo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
