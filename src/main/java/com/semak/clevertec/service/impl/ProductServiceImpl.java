package com.semak.clevertec.service.impl;

import com.semak.clevertec.converter.ProductDtoConverter;
import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.exception.ProductNotFoundException;
import com.semak.clevertec.model.Product;
import com.semak.clevertec.repository.ProductRepository;
import com.semak.clevertec.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAll() {
        List<Product> product = (List<Product>) productRepository.findAll();
        return product.stream()
                .map(productDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getById(@PathParam("id") Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("the user with this id was not found"));
        return productDtoConverter.convertToDto(product);
    }

    @Override
    @Transactional
    public void save(ProductDto productDto) {
        Product card = productDtoConverter.convertFromDto(productDto);
        productRepository.save(card);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
