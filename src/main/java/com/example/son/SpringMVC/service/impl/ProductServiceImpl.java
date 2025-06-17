package com.example.son.SpringMVC.service.impl;

import com.example.son.SpringMVC.dao.ProductDAO;
import com.example.son.SpringMVC.dto.ProductDTO;
import com.example.son.SpringMVC.entity.Product;
import com.example.son.SpringMVC.exception.ProductNotFoundException;
import com.example.son.SpringMVC.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor // ✅ Lombok tự sinh constructor với field final
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public void add(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        productDAO.add(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productDAO.findById(productDTO.getId());
        if(product != null) {
            product.setName(productDTO.getName());
            productDAO.update(product);
        }
        return productDTO;
    }

    @Override
    public void delete(Integer id) {
        Product product = productDAO.findById(id);;
        if (product != null) {
            productDAO.delete(product);
        }
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productDAO.findAll();
        for (Product product : products) {
            productDTOS.add(convertToDTO(product));
        }
        return productDTOS;
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        return productDTO;
    }


    @Override
    public ProductDTO findById(Integer id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm với id = " + id);
        }
        return convertToDTO(product);
    }
}
