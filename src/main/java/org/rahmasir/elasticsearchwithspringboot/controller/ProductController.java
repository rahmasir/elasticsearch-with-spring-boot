package org.rahmasir.elasticsearchwithspringboot.controller;

import org.rahmasir.elasticsearchwithspringboot.model.Product;
import org.rahmasir.elasticsearchwithspringboot.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "API for managing products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Operation(summary = "Create a new product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @GetMapping
    @Operation(summary = "Get all products")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product by ID")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
