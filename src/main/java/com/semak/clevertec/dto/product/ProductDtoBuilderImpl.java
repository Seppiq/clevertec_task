package com.semak.clevertec.dto.product;

public class ProductDtoBuilderImpl implements ProductDtoBuilder {

    ProductDto productDto = new ProductDto();

    @Override
    public ProductDtoBuilder setProduct(String product) {
        productDto.setProduct(product);
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
    public ProductDto build() {
        return productDto;
    }
}
