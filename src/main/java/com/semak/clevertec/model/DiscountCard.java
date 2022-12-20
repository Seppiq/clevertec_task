package com.semak.clevertec.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "discount_card")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class DiscountCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "discount", nullable = false)
    private Double discountPercent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return Objects.equals(id, that.id) && Objects.equals(cardName, that.cardName) && Objects.equals(discountPercent, that.discountPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardName, discountPercent);
    }
}
