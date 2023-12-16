package com.ECommerce.WebApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor @Data
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
}
