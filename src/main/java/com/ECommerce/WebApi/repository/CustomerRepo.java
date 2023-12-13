package com.ECommerce.WebApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ECommerce.WebApi.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}