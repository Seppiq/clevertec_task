package com.semak.clevertec.dto.product;

public interface ProductDtoBuilder {

    ProductDtoBuilder setProduct(String product);

    ProductDtoBuilder setPrice(Double price);

    ProductDtoBuilder setQuantity(Integer quantity);

    ProductDtoBuilder setTotalPrice(Double totalPrice);

    ProductDto build();
}
