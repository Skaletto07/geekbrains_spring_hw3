package com.kostkin.hw_3.controllers;

import com.kostkin.hw_3.models.Product;
import com.kostkin.hw_3.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public List<Product> all() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findOneById(@PathVariable Long id) {
        Product product = null;
        Optional<Product> byId = repository.findById(id);
        if (byId.isPresent()) {
            product = byId.get();
        }
        return product;
    }


    @PostMapping("/products/add")
    public void addProduct(Product product) {
        repository.save(product);

    }

    @PostMapping("/products/delete/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
