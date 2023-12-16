package com.ECommerce.WebApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderResponseDto {
    private Long customerId;
    private ArrayList<OrderItemDto> product;
}
