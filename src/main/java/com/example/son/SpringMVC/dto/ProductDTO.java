package com.example.son.SpringMVC.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;

    @NotBlank(message = "Đây là trường bắt buộc")
    @Size(min = 6, message = "Tên phải có ít nhất 6 ký tự")
    private String name;
}
