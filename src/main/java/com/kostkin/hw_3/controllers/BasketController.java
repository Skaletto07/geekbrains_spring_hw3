package com.kostkin.hw_3.controllers;

import com.kostkin.hw_3.models.Product;
import com.kostkin.hw_3.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/get")
    public List<Product> productList() {
        return basketService.getProducts();
    }

    @PostMapping("/addOne")
    public void addProduct(@RequestBody Product product) {
        basketService.addProduct(product);
    }

    @PostMapping("/addMore")
    public void addProducts(@RequestBody Product... products) {
        basketService.addProducts(products);
    }

    @DeleteMapping("/delete")
    public void deleteProductFromBasket(@RequestBody Product product) {
        basketService.deleteProductFromBasket(product);
    }
}
