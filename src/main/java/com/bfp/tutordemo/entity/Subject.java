package com.bfp.tutordemo.entity;

import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    public Subject(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<SubjectLevel> subjectLevels;

}
