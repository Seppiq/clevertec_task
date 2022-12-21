package com.semak.clevertec.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private Double total;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "receipt")
    private Receipt receipt;

    @PrePersist
    void prePersist() {
        calculateTotal();
    }

    @PreUpdate
    void preUpdate() {
        calculateTotal();
    }

    private void calculateTotal() {
        total = quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
