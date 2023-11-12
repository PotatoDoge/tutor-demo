package com.bfp.tutordemo.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentDTO {

    @NotBlank(message = "First name should not be blank")
    private String firstName;

    @NotBlank(message = "Last name should not be blank")
    private String lastName;

    @NotNull
    @Email(message = "Please provide a valid email address")
    private String email;
}
