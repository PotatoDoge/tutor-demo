package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Level;
import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.AppointmentDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.AppointmentRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final SubjectLevelService subjectLevelService;
    private final StudentService studentService;

    public Appointment save(Long studentId,Long subjectLevelId, AppointmentDTO appointmentDTO){
        Student student = studentService.findById(studentId).orElse(null);
        SubjectLevel subjectLevel = subjectLevelService.findById(subjectLevelId).orElse(null);
        if(student == null || subjectLevel == null){
            throw new NotFoundInDatabase("Either student or subjectLevel were not found in database");
        }

        Appointment appointment = new Appointment(null, student, subjectLevel, appointmentDTO.getDescription(), appointmentDTO.getAppointmentDateTime());
        appointment = appointmentRepository.save(appointment);
        //return new Appointment();
        return appointment;
    }

    public Optional<Appointment> findById(Long id){
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public void delete(Long id){
        appointmentRepository.deleteById(id);
        System.out.println("deleted");
    }

    public Level update(Long id, AppointmentDTO levelDTO){
        return null;
    }
}
