package com.semak.clevertec.converter.impl;

import com.semak.clevertec.converter.ReceiptDtoConverter;
import com.semak.clevertec.dto.receipt.ReceiptDto;
import com.semak.clevertec.model.Receipt;

public class ReceiptDtoConverterImpl implements ReceiptDtoConverter {
    @Override
    public Receipt convertFromDto(ReceiptDto receiptDto) {
        return Receipt.builder()
                .total(receiptDto.getTotal())
                .build();
    }

    @Override
    public ReceiptDto convertToDto(Receipt receipt) {
        return null;
    }
}
