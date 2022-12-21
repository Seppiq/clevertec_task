package com.semak.clevertec.controller;

import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.model.Product;
import com.semak.clevertec.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService receiptService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getReceipts() {
        return ok(receiptService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@Validated @RequestBody ProductDto product) {
        receiptService.save(product);
        return ok().build();
    }
}
