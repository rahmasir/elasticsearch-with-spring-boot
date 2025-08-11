package org.rahmasir.elasticsearchwithspringboot.service;

import org.rahmasir.elasticsearchwithspringboot.model.Product;
import org.rahmasir.elasticsearchwithspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String query) {
        return productRepository.findByQuery(query);
    }

    public List<Product> searchProductsFuzzy(String query) {
        return productRepository.findByQueryWithFuzziness(query);
    }
}
