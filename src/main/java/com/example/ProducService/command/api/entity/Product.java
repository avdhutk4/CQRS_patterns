package com.example.ProducService.command.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    private String productId;

    private String name;

    private BigDecimal price;
    private Integer quantity;
}
