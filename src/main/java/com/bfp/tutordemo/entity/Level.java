package com.bfp.tutordemo.entity;

import com.bfp.tutordemo.entity.linkingTables.SubjectLevelTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {

    public Level(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "level")
    private List<SubjectLevelTable> subjectLevelTables;

}
