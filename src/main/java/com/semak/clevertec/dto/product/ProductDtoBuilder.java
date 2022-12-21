package com.semak.clevertec.dto.product;

import com.semak.clevertec.model.Receipt;

public interface ProductDtoBuilder {

    ProductDtoBuilder setProduct(String product);

    ProductDtoBuilder setPrice(Double price);

    ProductDtoBuilder setQuantity(Integer quantity);

    ProductDtoBuilder setTotalPrice(Double totalPrice);

    ProductDtoBuilder setReceipt(Receipt receipt);

    ProductDto build();
}
