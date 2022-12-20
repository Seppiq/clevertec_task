package com.semak.clevertec.dto.receipt;

import com.semak.clevertec.dto.card.CardDto;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class ReceiptDto {
    Long id;

    String description;

    CardDto cardDto;

    Double total;

    Double discount;

    ZonedDateTime createDate;

    ZonedDateTime updateDate;
}
