package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.linkingTables.TutorAppointment;
import com.bfp.tutordemo.repository.impl.TutorAppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorAppointmentService {

    private final AppointmentService appointmentService;
    private final TutorService tutorService;
    private final TutorAppointmentRepository tutorAppointmentRepository;

    public TutorAppointment acceptAppointment(Long appointmentId, Long tutorId){
        Appointment appointment = appointmentService.findById(appointmentId).orElse(null);
        Tutor tutor = tutorService.findById(tutorId);
        TutorAppointment tutorAppointment = new TutorAppointment();
        tutorAppointment.setTutor(tutor);
        tutorAppointment.setAppointment(appointment);
        tutorAppointment.setStatus("ACCEPTED");
        return tutorAppointmentRepository.save(tutorAppointment);
    }

}
