package com.example.ProducService.command.api.Aggregate;

import com.example.ProducService.command.api.commands.CreateProductCommand;
import com.example.ProducService.command.api.events.ProductPublishEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class AggregateCommandHandler {

    @AggregateIdentifier
    private String productId;  // this will match with the productId of the createProductCommand TargetAggregateIdentifier
    private String name;
    private BigDecimal price;
    private Integer quantity;


    @CommandHandler
    public AggregateCommandHandler(CreateProductCommand createProductCommand) {

        // all the validations need to be added

        // after validation need to publish event

        ProductPublishEvent productPublishEvent = new ProductPublishEvent();
                BeanUtils.copyProperties(createProductCommand , productPublishEvent);

        AggregateLifecycle.apply(productPublishEvent); //event is published
        // for the event sourcing like store each state into and event store

        // so we can create a copy of the same event multiple times




    }

    public AggregateCommandHandler() {
    }

    @EventSourcingHandler
    public void on(ProductPublishEvent productPublishEvent) {
        // for the event sourcing like store each state into and event store

        // so we can create a copy of the same event multiple times

        // like zomato we can see order the previous order again that is event store

        this.productId = productPublishEvent.getProductId();
        this.name = productPublishEvent.getName();
        this.price = productPublishEvent.getPrice();
        this.quantity= productPublishEvent.getQuantity();

    }

}
