package com.bfp.tutordemo.entity;

import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.entity.linkingTables.TutorAppointment;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_level_id")
    @JsonIgnore
    private SubjectLevel subjectLevel;

    @OneToMany(mappedBy = "appointment")
    @JsonIgnore
    private List<TutorAppointment> tutorAppointment;

    public Appointment(Long id, Student student, SubjectLevel subjectLevelId, String description, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.subjectLevel = subjectLevelId;
        this.student = student;
        this.description = description;
        this.appointmentDateTime = appointmentDateTime;

    }
}
