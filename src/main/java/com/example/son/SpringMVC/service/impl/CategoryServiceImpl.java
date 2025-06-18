package com.example.son.SpringMVC.service.impl;

import com.example.son.SpringMVC.dao.CategoryRepository;
import com.example.son.SpringMVC.dto.CategoryDTO;
import com.example.son.SpringMVC.entity.Category;
import com.example.son.SpringMVC.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryDTO> findAllCategory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(cat -> new CategoryDTO(cat.getId(), cat.getName()));
    }
}
