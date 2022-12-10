package com.kostkin.hw_3.controllers;

import com.kostkin.hw_3.Dto.ProductDto;
import com.kostkin.hw_3.converters.ProductConverter;
import com.kostkin.hw_3.models.Product;
import com.kostkin.hw_3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductConverter converter;

    @GetMapping
    public Page<ProductDto> all(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "part_title", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return service.findAll(minPrice, maxPrice, namePart, page)
                .map(converter::entityToDto);
    }

    @GetMapping("/{id}")
    public ProductDto findOneById(@PathVariable Long id) {
        Product oneById = service.findOneById(id);
        return converter.entityToDto(oneById);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        Product update = service.update(productDto);
        return converter.entityToDto(update);
    }

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        Product product = converter.dtoToEntity(productDto);
        service.addProduct(product);
        return converter.entityToDto(product);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
