package com.ECommerce.WebApi.service;

import org.springframework.stereotype.Service;
import lombok.*;
import com.ECommerce.WebApi.repository.OrderRepo;
import com.ECommerce.WebApi.dto.OrderRequestDto;
import com.ECommerce.WebApi.dto.OrderRequestDto;
import com.ECommerce.WebApi.model.Order;
import com.ECommerce.WebApi.model.Customer;
import com.ECommerce.WebApi.dto.OrderItemDto;
import com.ECommerce.WebApi.model.OrderItem;
import com.ECommerce.WebApi.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderItemService OrderItemService;
    private final CustomerService customerService;
    private final ProductService productService;

    public Object createOrder(OrderRequestDto orderDTO) {
        // Get Customer
        Customer customer = customerService.getCustomer(orderDTO.getCustomerId());

        // Create Order
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(orderDTO.getProducts().stream().mapToDouble(OrderItemDto::getSubtotal).sum());

        Order savedOrder = orderRepo.save(order);

        order.setCustomer(customer);
        // Create Order Items
        ArrayList<OrderItem> orderItems = createOrderItems(orderDTO.getProducts(), savedOrder);

        OrderRequestDto orderResponseDTO = new OrderRequestDto();
        orderResponseDTO.setCustomerId(customer.getId());
        orderResponseDTO.setOrderDate(LocalDateTime.now());
        orderResponseDTO.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDTO.setOrderItems(orderItems);


        return orderResponseDTO;
    }

    public ArrayList<OrderItem> createOrderItems(ArrayList<OrderItemDto> orderItemDTOs, Order order) {

        List<OrderItem> orderItems = orderItemDTOs.stream().map((OrderItemDto orderItemDTO) -> {
            Product product = productService.getProductById(orderItemDTO.getProductId());
            return orderItemDTO.createOrderItem(orderItemDTO, product, order);
        }).collect(Collectors.toList());

        ArrayList<OrderItem> savedOrderItems = new ArrayList<>(orderItems);

        return savedOrderItems;

    }
}
