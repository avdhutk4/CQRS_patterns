package com.example.ProducService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPublishEvent {

    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}