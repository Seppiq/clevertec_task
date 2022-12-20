package com.semak.clevertec.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "receipts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Set<Product> product;

    @Column(nullable = false)
    String description;

    @Column
    private Double total;
    @Column
    private LocalDateTime date;

    @OneToOne
    DiscountCard discountCard;

    @Column
    private Boolean isDiscount;

    @Column(nullable = false)
    Double discount;

    @PrePersist
    void prePersist() {
        calculateTotal();
    }

    @PreUpdate
    void preUpdate() {
        calculateTotal();
    }

    private void calculateTotal() {
        if (isDiscount) {
            for (Product product1 : product) {
                total += product1.getTotal() * discountCard.getDiscountPercent();
            }
        } else {
            for (Product product1 : product) {
                total += product1.getTotal();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Receipt receipt = (Receipt) o;
        return id != null && Objects.equals(id, receipt.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
