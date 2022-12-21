package com.semak.clevertec.service.impl;

import com.semak.clevertec.converter.CardDtoConverter;
import com.semak.clevertec.dto.card.CardDto;
import com.semak.clevertec.exception.ProductNotFoundException;
import com.semak.clevertec.model.DiscountCard;
import com.semak.clevertec.repository.DiscountCardRepository;
import com.semak.clevertec.service.CardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final DiscountCardRepository discountCardRepository;

    private final CardDtoConverter cardDtoConverter;

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getAll() {
        List<DiscountCard> discountCards = (List<DiscountCard>) discountCardRepository.findAll();
        return discountCards.stream().map(cardDtoConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CardDto getById(@PathParam("id") Long id) {

        DiscountCard discountCard = discountCardRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("the user with this id was not found"));
        return cardDtoConverter.convertToDto(discountCard);
    }

    @Override
    public void save(CardDto cardDto) {
        DiscountCard card = cardDtoConverter.convertFromDto(cardDto);
        discountCardRepository.save(card);
    }
}
