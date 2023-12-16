package com.ECommerce.WebApi.controller;


import com.ECommerce.WebApi.dto.OrderRequestDto;
import com.ECommerce.WebApi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Object createdOrder = orderService.createOrder(orderRequestDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }


}
