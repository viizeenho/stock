package com.ada.projeto.repository;

import com.ada.projeto.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByProduct_Id(Long productId);

    void deleteByProduct_Id(Long productId);
}
