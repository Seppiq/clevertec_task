package com.semak.clevertec.converter.impl;

import com.semak.clevertec.converter.CardDtoConverter;
import com.semak.clevertec.dto.card.CardDto;
import com.semak.clevertec.model.DiscountCard;
import org.springframework.stereotype.Component;

@Component
public class CardDtoConverterImpl implements CardDtoConverter {

    @Override
    public DiscountCard convertFromDto(CardDto cardDto) {
        return DiscountCard.builder()
                .cardName(cardDto.getCardName())
                .discountPercent(cardDto.getDiscountPercent())
                .build();
    }

    @Override
    public CardDto convertToDto(DiscountCard discountCard) {
        return CardDto.builder()
                .cardName(discountCard.getCardName())
                .discountPercent(discountCard.getDiscountPercent())
                .build();
    }
}
