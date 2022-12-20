package com.semak.clevertec.dto.product;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProductDto {
    @NotEmpty(message = "product could not be empty")
    private String product;

    private Double price;

    private Integer quantity;

    private Double totalPrice;
}

