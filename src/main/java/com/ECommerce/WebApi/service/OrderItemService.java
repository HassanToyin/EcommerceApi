package com.ECommerce.WebApi.service;


import com.ECommerce.WebApi.dto.OrderItemDto;
import com.ECommerce.WebApi.model.Order;
import com.ECommerce.WebApi.model.OrderItem;
import com.ECommerce.WebApi.model.Product;
import com.ECommerce.WebApi.repository.OrderItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OrderItemService {
    private final OrderItemRepo orderItemRepo;
    // private final ProductService productService;
    // private final OrderService orderService;

    public OrderItem createOrderItem(OrderItemDto orderItemDTO, Product product, Order order) {
        // Retrieve order details
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setSubtotal(product.getPrice() * orderItemDTO.getQuantity());
        return orderItemRepo.save(orderItem);
    }
}
