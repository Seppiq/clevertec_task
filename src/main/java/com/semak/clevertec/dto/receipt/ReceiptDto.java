package com.semak.clevertec.dto.receipt;

import com.semak.clevertec.model.DiscountCard;
import com.semak.clevertec.model.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class ReceiptDto {
    private Set<Product> product;

    private String description;

    private Double total;

    private LocalDateTime date;

    private Boolean isDiscount;

    private Double discount;

    private DiscountCard discountCard;
}
