package com.semak.clevertec.dto.card;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDto {

    @NotEmpty(message = "card could not be empty")
    private String cardName;

    private Double discountPercent;
}
