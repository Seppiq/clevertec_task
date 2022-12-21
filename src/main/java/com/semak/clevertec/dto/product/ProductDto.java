package com.semak.clevertec.dto.product;

import com.semak.clevertec.model.Receipt;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProductDto {
    @NotEmpty(message = "product could not be empty")
    private String name;

    private Double price;

    private Integer quantity;

    private Double totalPrice;

    private Long receipt;
}

