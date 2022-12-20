package com.semak.clevertec.converter;

import com.semak.clevertec.dto.card.CardDto;
import com.semak.clevertec.model.DiscountCard;

public interface CardDtoConverter {
    DiscountCard convertFromDto(CardDto cardDto);

    CardDto convertToDto(DiscountCard discountCard);
}
