package com.semak.clevertec.dto.field;

import com.semak.clevertec.dto.product.ProductDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptFieldDto {

    private Long id;

    private ProductDto product;

    private Integer quantity;

    private Double total;
}
