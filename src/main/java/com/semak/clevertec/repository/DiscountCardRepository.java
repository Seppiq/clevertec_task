package com.semak.clevertec.repository;

import com.semak.clevertec.model.DiscountCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCardRepository extends CrudRepository<DiscountCard, Long> {

}
