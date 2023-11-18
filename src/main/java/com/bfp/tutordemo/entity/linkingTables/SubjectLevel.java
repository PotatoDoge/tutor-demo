package com.bfp.tutordemo.entity.linkingTables;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "subject_level")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SubjectLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectLevel", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public SubjectLevel(Long id, Subject subject, Level level){
        this.id = id;
        this.subject = subject;
        this.level = level;
    }
}
