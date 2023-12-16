package com.ECommerce.WebApi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.List;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")


public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id" , name = "customerId")
    private Customer customer;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "totalAmount")
    private Double totalAmount;

    @Column(name = "orderItems")
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
