package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.AppointmentDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.AppointmentService;
import com.bfp.tutordemo.service.impl.TutorAppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final TutorAppointmentService tutorAppointmentService;

    @GetMapping
    public ResponseEntity<HttpResponse> getAppointments(@RequestParam(name = "subject", required = false)String subject, @RequestParam(name = "level", required = false) String level){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointments",appointmentService.findAll(subject,level)))
                .message("Appointments retrieved!")
                .build());
    }
    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> getAppointmentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.findById(id)))
                .message("Appointment retrieved!")
                .build());
    }

    @PostMapping("student/{studentId}/subjectLevel/{subjectLevelId}")
    public ResponseEntity<HttpResponse> createAppointment(@PathVariable("studentId") Long studentId, @PathVariable("subjectLevelId") Long subjectLevelId, @RequestBody @Valid AppointmentDTO appointmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.save(studentId,subjectLevelId, appointmentDTO)))
                .message("Appointment created!")
                .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> updateAppointment(@PathVariable("id")Long id, @Valid @RequestBody AppointmentDTO appointment){
        return ResponseEntity.ok(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.update(id,appointment)))
                .message("Appointment updated!")
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse> deleteSubjectById(@PathVariable("id")Long id){
        appointmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Appointment deleted!")
                .build());
    }

    @PostMapping("{appointmentId}/accept/tutor/{tutorId}")
    public ResponseEntity<HttpResponse> acceptAppointment(@PathVariable("appointmentId") Long appointmentId, @PathVariable("tutorId")Long tutorId){
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("tutorAppointment",tutorAppointmentService.acceptAppointment(appointmentId,tutorId)))
                .message("Appointment accepted by a tutor!")
                .build());
    }

}
