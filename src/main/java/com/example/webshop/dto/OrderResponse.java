package com.example.webshop.dto;

public class OrderResponse {
    private String orderId;
    private String message;
    private double totalAmount;

    public OrderResponse(String orderId, String message, double totalAmount) {
        this.orderId = orderId;
        this.message = message;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMessage() {
        return message;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
