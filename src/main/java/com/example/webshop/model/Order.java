package com.example.webshop.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private CustomerInfo customerInfo;
    private List<OrderItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;

    public Order(String id, CustomerInfo customerInfo, List<OrderItem> items, double totalAmount, LocalDateTime orderDate) {
        this.id = id;
        this.customerInfo = customerInfo;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Getters
    public String getId() {
        return id;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
