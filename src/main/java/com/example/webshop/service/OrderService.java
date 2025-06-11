package com.example.webshop.service;

import com.example.webshop.dto.OrderRequest;
import com.example.webshop.dto.OrderResponse;
import com.example.webshop.model.Order;
import com.example.webshop.model.OrderItem;
import com.example.webshop.model.Product;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public OrderResponse processOrder(OrderRequest request) {
        double totalAmount = 0;
        List<OrderItem> confirmedItems = new ArrayList<>();

        for (OrderItem item : request.getItems()) {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Antal måste vara större än 0 för produkt ID: " + item.getProductId());
            }

            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Produkt med ID " + item.getProductId() + " finns inte"));

            if (product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Inte tillräckligt i lager för produkt: " + product.getName());
            }

            // Minska lagret
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepository.save(product);  // Spara ändringen i lagret

            confirmedItems.add(item);
            totalAmount += product.getPrice() * item.getQuantity();
        }

        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, request.getCustomerInfo(), confirmedItems, totalAmount, LocalDateTime.now());

        orderRepository.save(order);

        return new OrderResponse(orderId, "Order mottagen!", totalAmount);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order med ID " + orderId + " finns inte."));
        orderRepository.delete(order);
    }

}
