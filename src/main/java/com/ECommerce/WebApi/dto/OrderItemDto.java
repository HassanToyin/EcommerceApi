package com.ECommerce.WebApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class OrderItemDto {
    private Long productId;
    private Integer quantity;
    private Double subtotal;
}
