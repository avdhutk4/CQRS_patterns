package com.example.ProducService.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier   // this will match with the aggregate productId with AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
