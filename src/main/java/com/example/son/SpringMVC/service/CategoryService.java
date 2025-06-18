package com.example.son.SpringMVC.service;

import com.example.son.SpringMVC.dto.CategoryDTO;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryDTO> findAllCategory(int page, int size);
}
