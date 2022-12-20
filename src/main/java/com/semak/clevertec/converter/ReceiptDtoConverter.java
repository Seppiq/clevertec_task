package com.semak.clevertec.converter;

import com.semak.clevertec.dto.receipt.ReceiptDto;
import com.semak.clevertec.model.Receipt;

public interface ReceiptDtoConverter {

    Receipt convertFromDto(ReceiptDto receiptDto);

    ReceiptDto convertToDto(Receipt receipt);
}
