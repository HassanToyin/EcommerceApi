package com.ECommerce.WebApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Data
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
