package com.example.son.SpringMVC.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotBlank(message = "Đây là trường bắt buộc")
    @Size(min = 6, message = "Tên phải có ít nhất 6 ký tự")
    private String name;

    @NotNull(message = "Đây là trường bắt buộc")
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotBlank(message = "Đây là trường bắt buộc")
    private String address;
}
