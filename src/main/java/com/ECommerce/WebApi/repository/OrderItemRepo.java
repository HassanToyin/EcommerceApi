package com.ECommerce.WebApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ECommerce.WebApi.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
