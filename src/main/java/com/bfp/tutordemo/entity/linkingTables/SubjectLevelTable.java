package com.bfp.tutordemo.entity.linkingTables;

import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Subject;
import jakarta.persistence.*;

@Entity
@Table(name = "subject_level")
public class SubjectLevelTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
}
