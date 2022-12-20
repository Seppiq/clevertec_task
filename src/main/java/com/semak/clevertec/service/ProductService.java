package com.semak.clevertec.service;

import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.model.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getById(Long id);

    void save(Product product);

    //ProductDto update(Long id);

    void delete(Long id);

    List<Product> getAllById(Long[] ids);

}
