package com.ECommerce.WebApi.service;

import java.util.ArrayList;

import com.ECommerce.WebApi.model.Order;
import org.springframework.stereotype.Service;
import lombok.*;

import com.ECommerce.WebApi.dto.ProductDto;
import com.ECommerce.WebApi.repository.ProductRepo;
import com.ECommerce.WebApi.model.Product;


@Service
@AllArgsConstructor

public class ProductService {
    private final ProductRepo productRepo;

    public Product createProduct(ProductDto productDTO) {

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return ProductRepo.save(product);
    }

    public Order getProductById(Long id) {
        return productRepo.findById(id).orElseThrow( () -> new RuntimeException("Product not found"));
    }

    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) productRepo.findAll();
    }

    public Product updateProduct(ProductDto productDTO, Long id) {

        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepo.save(product);
    }

    public Product deleteProduct(Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return product;
    }
}
