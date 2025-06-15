package com.example.son.SpringMVC.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 6, message = "Name must be at least 6 characters")
    private String name;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Birthdate is required")
    private LocalDate birthdate;

    @NotBlank(message = "Address is required")
    private String address;
}
