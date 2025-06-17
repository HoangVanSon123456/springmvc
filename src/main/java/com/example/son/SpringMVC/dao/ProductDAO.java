package com.example.son.SpringMVC.dao;

import com.example.son.SpringMVC.entity.Product;

import java.util.List;

public interface ProductDAO {

    void add(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findById(Integer id);

}
