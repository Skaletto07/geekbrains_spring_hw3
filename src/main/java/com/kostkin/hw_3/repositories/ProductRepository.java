package com.kostkin.hw_3.repositories;

import com.kostkin.hw_3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
