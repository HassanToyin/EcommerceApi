package com.ECommerce.WebApi.controller;


import com.ECommerce.WebApi.dto.ProductDto;
import com.ECommerce.WebApi.model.Order;
import com.ECommerce.WebApi.model.Product;
import com.ECommerce.WebApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

   // @GetMapping("/{id}")
    //public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        //Product product = productService.getProductById(id);
        //return new ResponseEntity<>(product, HttpStatus.OK);
    //}

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto ProductDto, @PathVariable Long id) {
        Product updatedProduct = productService.updateProduct(ProductDto, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.deleteProduct(id);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }
}