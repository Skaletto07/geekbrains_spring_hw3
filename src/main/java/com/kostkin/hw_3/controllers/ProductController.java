package com.kostkin.hw_3.controllers;

import com.kostkin.hw_3.Dto.ProductDto;
import com.kostkin.hw_3.models.Product;
import com.kostkin.hw_3.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProductDto> all() {
        return repository.findAll().stream().map(ProductDto::new).toList();
    }

    @GetMapping("/{id}")
    public ProductDto findOneById(@PathVariable Long id) {
        Product product = null;
        Optional<Product> byId = repository.findById(id);
        if (byId.isPresent()) {
            product = byId.get();
        }
        assert product != null;
        return new ProductDto(product);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> byId = repository.findById(id);
        Product product1 = null;
        if (byId.isPresent()) {
            product1 = byId.get();
            product1.setCost(product.getCost());
            product1.setTitle(product.getTitle());
        }
        assert product1 != null;
        return new ProductDto(repository.save(product1));
    }

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody Product product) {
        product.setId(null);
        return new ProductDto(repository.save(product));
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
