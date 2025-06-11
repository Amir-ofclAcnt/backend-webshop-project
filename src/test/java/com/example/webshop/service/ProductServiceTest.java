package com.example.webshop.service;

import com.example.webshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService service;

    @Test
    void testGetAllProducts() {
        List<Product> result = service.getAllProducts();
        assertFalse(result.isEmpty());
    }
}
