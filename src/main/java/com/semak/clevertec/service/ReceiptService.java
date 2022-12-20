package com.semak.clevertec.service;

import com.semak.clevertec.model.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> getAll();

    Receipt getById(Long id);

    void save(Receipt receipt);
}
