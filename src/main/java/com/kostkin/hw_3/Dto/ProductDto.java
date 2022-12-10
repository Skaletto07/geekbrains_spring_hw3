package com.kostkin.hw_3.Dto;

import com.kostkin.hw_3.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDto {

    private Long id;

    private String title;

    private double price;

}