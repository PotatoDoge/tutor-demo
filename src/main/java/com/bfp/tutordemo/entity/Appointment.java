package com.bfp.tutordemo.entity;

import com.bfp.tutordemo.entity.linkingTables.SubjectLevelTable;
import com.bfp.tutordemo.entity.linkingTables.TutorAppointmentTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime appointmentDateTime; // this will always be saved in UTC

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_level_id")
    private SubjectLevelTable subjectLevel;

    @OneToMany(mappedBy = "appointment")
    private List<TutorAppointmentTable> tutorAppointment;

}
