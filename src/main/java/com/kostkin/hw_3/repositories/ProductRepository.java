package com.kostkin.hw_3.repositories;

import com.kostkin.hw_3.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
