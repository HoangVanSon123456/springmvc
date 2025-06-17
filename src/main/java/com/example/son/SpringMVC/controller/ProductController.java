package com.example.son.SpringMVC.controller;

import com.example.son.SpringMVC.dto.ProductDTO;
import com.example.son.SpringMVC.entity.Product;
import com.example.son.SpringMVC.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProduct(@RequestParam(required = false) Integer id) {
        if (id != null) {
            return ResponseEntity.ok(productService.findById(id));
        }
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> add(@Valid @RequestBody ProductDTO productDTO) {
        productService.add(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping
    public ProductDTO update(@RequestParam Integer id, @Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        productService.update(productDTO);
        return ResponseEntity.ok(productDTO).getBody();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        productService.delete(id);
        return ResponseEntity.ok("Xoá thành công");
    }

    @GetMapping("/crash")
    public ResponseEntity<?> crash() {
        // Gây lỗi runtime bất ngờ
        String s = null;
        s.length(); // Gây NullPointerException
        return ResponseEntity.ok().build();
    }

}
