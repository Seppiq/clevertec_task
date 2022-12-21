package com.semak.clevertec.converter.impl;

import com.semak.clevertec.converter.ProductDtoConverter;
import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.dto.product.ProductDtoBuilder;
import com.semak.clevertec.dto.product.ProductDtoBuilderImpl;
import com.semak.clevertec.model.Product;
import com.semak.clevertec.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverterImpl implements ProductDtoConverter {
    @Override
    public Product convertFromDto(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                //.receipt(productDto.getReceipt())
                .total(productDto.getTotalPrice())
                .build();
    }

    @Override
    public ProductDto convertToDto(Product product) {
        ProductDtoBuilder productDto = new ProductDtoBuilderImpl();
        return productDto
                .setProduct(product.getName())
                .setPrice(product.getPrice())
                .setQuantity(product.getQuantity())
                .setTotalPrice(product.getTotal())
                //.setReceipt(product.getReceipt())
                .build();
    }

//    @Override
//    public List<ProductDto> convertToDtoList(List<Product> product) {
//        return null;
//    }
}
