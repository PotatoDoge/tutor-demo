package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Student;
import com.bfp.tutordemo.entity.dto.AppointmentDTO;
import com.bfp.tutordemo.entity.linkingTables.SubjectLevel;
import com.bfp.tutordemo.repository.impl.AppointmentRepository;
import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bfp.tutordemo.util.AppointmentConstants.FREE_APPOINTMENT;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final SubjectLevelService subjectLevelService;
    private final StudentService studentService;

    public Appointment save(Long studentId,Long subjectLevelId, AppointmentDTO appointmentDTO){
        Student student = studentService.findById(studentId);
        SubjectLevel subjectLevel = subjectLevelService.findById(subjectLevelId).orElse(null);
        if(student == null || subjectLevel == null){
            throw new NotFoundInDatabase("Either student or subjectLevel were not found in database");
        }

        Appointment appointment = new Appointment(null, student, subjectLevel, appointmentDTO.getDescription(), appointmentDTO.getAppointmentDateTime());
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }

    public Optional<Appointment> findById(Long id){
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAll(String subject, String level){
        if(subject == null || level == null){
            return appointmentRepository.findAll();
        }

        SubjectLevel subjectLevel = subjectLevelService.findBySubjectAndLevel(subject,level);
        return appointmentRepository.findBySubjectLevelAndStatus(subjectLevel, FREE_APPOINTMENT);

    }

    public void delete(Long id){
        appointmentRepository.deleteById(id);
        System.out.println("deleted");
    }

    public Appointment update(Long id, AppointmentDTO appointmentDTO){
        Appointment appointment = findById(id).orElse(null);
        if(appointment == null){
            throw new NotFoundInDatabase("No Appointment with that ID was found in the database");
        }
        appointment.setDescription(appointmentDTO.getDescription());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        return appointmentRepository.save(appointment);
    }
}
