package com.semak.clevertec.service;

import com.semak.clevertec.dto.card.CardDto;

import java.util.List;

public interface CardService {

    List<CardDto> getAll();

    CardDto getById(Long id);
}
