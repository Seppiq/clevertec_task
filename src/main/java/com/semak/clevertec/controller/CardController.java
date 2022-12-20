package com.semak.clevertec.controller;

import com.semak.clevertec.dto.card.CardDto;
import com.semak.clevertec.dto.product.ProductDto;
import com.semak.clevertec.model.DiscountCard;
import com.semak.clevertec.model.Product;
import com.semak.clevertec.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<List<CardDto>> getReceipts() {
        return ok(cardService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@Validated @RequestBody DiscountCard discountCard) {
        cardService.save(discountCard);
        return ok().build();
    }
}
