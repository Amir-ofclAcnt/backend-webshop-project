package com.example.webshop.model;

import lombok.Getter;
import lombok.Setter;

@Setter
public class OrderItem {
    private Long productId;
    @Getter
    private int quantity;

    // Getters and setters
    public long getProductId() {
        return productId;
    }

}
