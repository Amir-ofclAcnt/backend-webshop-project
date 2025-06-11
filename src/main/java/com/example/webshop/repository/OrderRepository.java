package com.example.webshop.repository;

import com.example.webshop.model.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orders.get(id));
    }

    public void delete(Order order) {
        if (!orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Order med id " + order.getId() + " finns inte.");
        }
        orders.remove(order.getId());
    }
}
