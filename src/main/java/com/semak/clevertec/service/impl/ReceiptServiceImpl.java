package com.semak.clevertec.service.impl;

import com.semak.clevertec.model.Receipt;
import com.semak.clevertec.repository.ReceiptRepository;
import com.semak.clevertec.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> getAll() {
        return (List<Receipt>) receiptRepository.findAll();
    }

    @Override
    public Receipt getById(Long id) {
        return receiptRepository.findById(id).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }
}
