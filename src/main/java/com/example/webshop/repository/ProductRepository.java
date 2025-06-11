package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    public ProductRepository() {
        // Initiera testdata med 7 parametrar enligt din Product-konstruktor
        products.put(1L, new Product(1L, "Laptop", "Bra laptop", 999.99, "laptop.jpg", 10, "Electronics"));
        products.put(2L, new Product(2L, "Gaming Mouse", "Wireless gaming mouse", 49.99, "mouse.jpg", 50, "Electronics"));
        // Lägg till fler produkter vid behov
    }

    // Hämta alla produkter som lista
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    // Hämta produkt via ID
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    // Spara eller uppdatera produkt
    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    // Ta bort produkt via ID, kastar IllegalArgumentException om produkten saknas
    public void delete(Product product) {
        if (!products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Produkten finns inte för borttagning");
        }
        products.remove(product.getId());
    }
}
