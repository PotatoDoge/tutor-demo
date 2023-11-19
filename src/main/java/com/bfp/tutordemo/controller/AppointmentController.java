package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.AppointmentDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.AppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public HttpResponse getAppointments(@RequestParam(name = "subject", required = false)String subject, @RequestParam(name = "level", required = false) String level){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointments",appointmentService.findAll(subject,level)))
                .message("Appointments retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
    @GetMapping("{id}")
    public HttpResponse getAppointmentById(@PathVariable("id") Long id){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.findById(id)))
                .message("Appointment retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping("student/{studentId}/subjectLevel/{subjectLevelId}")
    public HttpResponse createAppointment(@PathVariable("studentId") Long studentId, @PathVariable("subjectLevelId") Long subjectLevelId, @RequestBody @Valid AppointmentDTO appointmentDTO){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.save(studentId,subjectLevelId, appointmentDTO)))
                .message("Appointment created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateAppointment(@PathVariable("id")Long id, @Valid @RequestBody AppointmentDTO appointment){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("appointment",appointmentService.update(id,appointment)))
                .message("Appointment updated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteSubjectById(@PathVariable("id")Long id){
        appointmentService.delete(id);
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Appointment deleted!")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }

}
