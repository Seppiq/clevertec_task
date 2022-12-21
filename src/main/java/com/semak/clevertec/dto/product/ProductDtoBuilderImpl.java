package com.semak.clevertec.dto.product;

import com.semak.clevertec.model.Receipt;

public class ProductDtoBuilderImpl implements ProductDtoBuilder {

    ProductDto productDto = new ProductDto();

    @Override
    public ProductDtoBuilder setProduct(String name) {
        productDto.setName(name);
        return this;
    }

    @Override
    public ProductDtoBuilder setPrice(Double price) {
        productDto.setPrice(price);
        return this;
    }

    @Override
    public ProductDtoBuilder setQuantity(Integer quantity) {
        productDto.setQuantity(quantity);
        return this;
    }

    @Override
    public ProductDtoBuilder setTotalPrice(Double totalPrice) {
        productDto.setTotalPrice(totalPrice);
        return this;
    }

    @Override
    public ProductDtoBuilder setReceipt(Receipt receipt) {
        productDto.setReceipt(receipt.getId());
        return this;
    }

    @Override
    public ProductDto build() {
        return productDto;
    }
}
