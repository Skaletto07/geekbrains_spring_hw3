package com.kostkin.hw_3.controllers;

import com.kostkin.hw_3.models.Products;
import com.kostkin.hw_3.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allProducts")
    public String all(Model model) {
        List<Products> all = repository.findAll();
        model.addAttribute("products", all);
        return "products";
    }

    @GetMapping("/allProducts/{id}")
    public String findOneById(Model model, @PathVariable Long id) {
        Products product = null;
        Optional<Products> byId = repository.findById(id);
        if (byId.isPresent()) {
            product = byId.get();
        }
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("product") Products product) {
        return "newProduct";
    }

    @PostMapping("/update")
    public String addProduct(@ModelAttribute("product") Products product) {
        repository.save(product);
        return "redirect:/allProducts";
    }
}
