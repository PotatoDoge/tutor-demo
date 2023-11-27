package com.bfp.tutordemo.service.impl;

import com.bfp.tutordemo.entity.Appointment;
import com.bfp.tutordemo.entity.Tutor;
import com.bfp.tutordemo.entity.linkingTables.TutorAppointment;
import com.bfp.tutordemo.repository.impl.TutorAppointmentRepository;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.bfp.tutordemo.util.AppointmentConstants.FREE_APPOINTMENT;
import static com.bfp.tutordemo.util.AppointmentConstants.TAKEN_APPOINTMENT;

@Service
@RequiredArgsConstructor
public class TutorAppointmentService {

    private final AppointmentService appointmentService;
    private final TutorService tutorService;
    private final TutorAppointmentRepository tutorAppointmentRepository;

    public TutorAppointment acceptAppointment(Long appointmentId, Long tutorId){
        Appointment appointment = appointmentService.findById(appointmentId);
        if (!appointment.getStatus().equals(FREE_APPOINTMENT)) {
            throw new ValueExistsInDatabase("The appointment is already taken!");
        }
        Tutor tutor = tutorService.findById(tutorId);
        TutorAppointment tutorAppointment = new TutorAppointment();
        tutorAppointment.setTutor(tutor);
        tutorAppointment.setAppointment(appointment);
        tutorAppointment.setStatus("ACCEPTED");
        tutorAppointment = tutorAppointmentRepository.save(tutorAppointment);
        appointmentService.changeStatus(appointmentId, TAKEN_APPOINTMENT);
        return tutorAppointment;
    }

}
