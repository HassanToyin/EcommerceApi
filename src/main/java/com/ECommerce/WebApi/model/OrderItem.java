package com.ECommerce.WebApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
//import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor @Data

//@Table(name = "order_item")

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JdbcTypeCode(SqlTypes.JSON)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    private Integer quantity;

    private Double subtotal;
}
