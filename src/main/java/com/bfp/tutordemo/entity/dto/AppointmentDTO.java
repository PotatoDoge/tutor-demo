package com.bfp.tutordemo.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    @NotBlank(message = "Description should not be blank")
    private String description;

    @NotNull(message = "Appointment's date and time should not be null nor blank")
    private LocalDateTime appointmentDateTime; // this will always be saved in UTC
}
