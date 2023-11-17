package com.bfp.tutordemo.entity.linkingTables;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.bfp.tutordemo.entity.Tutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tutor_appointment")
@Data
@AllArgsConstructor
public class TutorAppointmentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Float duration;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
