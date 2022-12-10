package com.kostkin.hw_3.service;

import com.kostkin.hw_3.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BasketService {
    private final List<Product> basketOfProducts = new ArrayList<>();

    public List<Product> getProducts() {
        return basketOfProducts;
    }

    public void addProduct(Product product) {
        basketOfProducts.add(product);
    }

    public void addProducts(Product... products) {
        basketOfProducts.addAll(Arrays.asList(products));
    }

    public void deleteProductFromBasket(Product product) {
        basketOfProducts.remove(product);
    }
}
