package com.example.son.SpringMVC.service;

import com.example.son.SpringMVC.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void add(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    void delete(Integer id);

    List<ProductDTO> findAll();

    ProductDTO findById(Integer id);
}
