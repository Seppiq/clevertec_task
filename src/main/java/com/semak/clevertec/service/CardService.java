package com.semak.clevertec.service;

import com.semak.clevertec.dto.card.CardDto;
import com.semak.clevertec.model.DiscountCard;
import com.semak.clevertec.model.Product;

import java.util.List;

public interface CardService {

    List<CardDto> getAll();

    CardDto getById(Long id);

    void save(DiscountCard card);
}
