package com.semak.clevertec.service;

import com.semak.clevertec.model.Receipt;
import jakarta.servlet.ServletOutputStream;

public interface PdfService {
    void generatePdf(Receipt receipt, ServletOutputStream outputStream);
}
