package com.bfp.tutordemo.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private String description;
    private LocalDateTime appointmentDateTime; // this will always be saved in UTC
    private String timezone;
}
