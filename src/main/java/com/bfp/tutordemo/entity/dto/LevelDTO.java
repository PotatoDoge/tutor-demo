package com.bfp.tutordemo.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LevelDTO {

    @NotBlank(message = "The name of the level should not be blank")
    private String name;

}
