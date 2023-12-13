package com.ECommerce.WebApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ECommerce.WebApi.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
