package com.example.webshop.service;

import com.example.webshop.exception.ProductNotFoundException;
import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Hämta alla produkter.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Hämta en specifik produkt baserat på ID.
     * Kastar ProductNotFoundException om produkten inte finns.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produkt med id " + id + " finns inte."));
    }

    /**
     * Skapa och spara en ny produkt.
     */
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * Uppdatera en befintlig produkt.
     * Kastar ProductNotFoundException om produkten inte finns.
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produkt med id " + id + " finns inte."));

        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        existing.setImageUrl(updatedProduct.getImageUrl());
        existing.setStockQuantity(updatedProduct.getStockQuantity());
        existing.setCategory(updatedProduct.getCategory());

        return productRepository.save(existing);
    }

    /**
     * Ta bort en produkt baserat på ID.
     * Kastar ProductNotFoundException om produkten inte finns.
     */
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produkt med id " + id + " finns inte."));
        productRepository.delete(product);
    }
}
