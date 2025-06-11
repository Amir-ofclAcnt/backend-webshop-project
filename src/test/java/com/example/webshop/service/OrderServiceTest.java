package com.example.webshop.service;

import com.example.webshop.dto.OrderRequest;
import com.example.webshop.dto.OrderResponse;
import com.example.webshop.model.CustomerInfo;
import com.example.webshop.model.OrderItem;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setup() {
        ProductRepository productRepository = new ProductRepository(); // har dummyprodukter
        OrderRepository orderRepository = new OrderRepository();
        orderService = new OrderService(productRepository, orderRepository);
    }

    @Test
    void testOrderTotalCalculation() {
        OrderRequest request = new OrderRequest();

        CustomerInfo customer = new CustomerInfo();
        customer.setName("Amir");
        customer.setAddress("Frihetsvägen 33");
        customer.setEmail("amir@example.com");
        request.setCustomerInfo(customer);

        OrderItem item = new OrderItem();
        item.setProductId(1L); // Laptop = 999.99
        item.setQuantity(2);

        request.setItems(List.of(item));

        OrderResponse response = orderService.processOrder(request);

        assertNotNull(response.getOrderId());
        assertEquals(1999.98, response.getTotalAmount(), 0.01);
        assertEquals("Order mottagen!", response.getMessage());
    }
}
