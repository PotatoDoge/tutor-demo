package com.bfp.tutordemo.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectDTO {

    @NotBlank(message = "The name of the subject should not be blank")
    private String name;

    @NotBlank(message = "The description of the subject should not be blank")
    private String description;

}
