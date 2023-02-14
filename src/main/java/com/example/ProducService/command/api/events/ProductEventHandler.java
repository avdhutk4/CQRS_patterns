package com.example.ProducService.command.api.events;

import com.example.ProducService.command.api.entity.Product;
import com.example.ProducService.command.api.entity.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {


    private ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductPublishEvent productPublishEvent) {
        // after listening to that event store that event into DB

        Product product = new Product();

        BeanUtils.copyProperties(productPublishEvent , product);

        productRepository.save(product);


    }
}
