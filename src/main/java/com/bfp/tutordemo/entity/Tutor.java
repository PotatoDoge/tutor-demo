package com.bfp.tutordemo.entity;

import com.bfp.tutordemo.entity.linkingTables.TutorAppointment;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Tutor extends BaseEntity{

    @OneToMany(mappedBy = "tutor")
    private List<TutorAppointment> tutorAppointment;

    public Tutor(Long id, String firstName, String lastName, String email ){
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }
}
