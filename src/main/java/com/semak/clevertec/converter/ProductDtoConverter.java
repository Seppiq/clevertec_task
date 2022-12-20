package com.semak.clevertec.converter;

import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.model.Product;

public interface ProductDtoConverter {
    Product convertFromDto(ProductDto productDto);

    ProductDto convertToDto(Product product);
}
