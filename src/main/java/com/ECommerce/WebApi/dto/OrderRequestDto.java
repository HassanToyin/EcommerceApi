package com.ECommerce.WebApi.dto;

import lombok.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequestDto {
    private Long customerId;
    private ArrayList<OrderItemDTO> products;
}
