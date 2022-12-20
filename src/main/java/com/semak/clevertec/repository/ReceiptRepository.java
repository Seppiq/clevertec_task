package com.semak.clevertec.repository;

import com.semak.clevertec.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
}
