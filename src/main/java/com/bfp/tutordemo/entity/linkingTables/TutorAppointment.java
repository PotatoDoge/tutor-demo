package com.bfp.tutordemo.entity.linkingTables;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Tutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutor_appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorAppointment {

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
