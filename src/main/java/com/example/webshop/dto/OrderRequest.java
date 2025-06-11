package com.example.webshop.dto;

import com.example.webshop.model.CustomerInfo;
import com.example.webshop.model.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;


import java.util.List;

public class OrderRequest {

    private CustomerInfo customerInfo;

    @NotEmpty(message = "Ordern måste innehålla minst en produkt")
    private List<OrderItem> items;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
