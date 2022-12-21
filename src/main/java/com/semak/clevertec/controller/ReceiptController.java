package com.semak.clevertec.controller;

import com.semak.clevertec.model.Receipt;
import com.semak.clevertec.service.PdfService;
import com.semak.clevertec.service.ReceiptService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    private final PdfService pdfService;

    @GetMapping
    public ResponseEntity<List<Receipt>> getReceipts() {
        return ok(receiptService.getAll());
    }

    @GetMapping("{id}")
    public Receipt getReceipt(@PathVariable Long id) {
        return receiptService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Validated @RequestBody Receipt receipt) {
        receiptService.save(receipt);
        return ok().build();
    }

    @SneakyThrows
    @GetMapping("/download/{id}")
    public void downloadReceipt(@PathVariable Long id, HttpServletResponse response) {
        var receipt = receiptService.getById(id);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        pdfService.generatePdf(receipt, response.getOutputStream());
    }
}
