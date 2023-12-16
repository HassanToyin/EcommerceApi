package com.ECommerce.WebApi.controller;


import com.ECommerce.WebApi.dto.CustomerDto;
import com.ECommerce.WebApi.model.Customer;
import com.ECommerce.WebApi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")

public class CustomerController {
    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> createCustomer(CustomerDto customerDtoI) {
        Customer createdCustomer = CustomerService.createCustomer(CustomerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Customer> getAllCustomer() {
        List<Customer> customer = CustomerService.getAllCustomers();
        return new ResponseEntity<>(Customer, HttpStatus.OK);
    }



}
