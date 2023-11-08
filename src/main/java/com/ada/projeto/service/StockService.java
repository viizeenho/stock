package com.ada.projeto.service;

import com.ada.projeto.dto.StockDTO;
import com.ada.projeto.model.Stock;

public interface StockService {
    Stock addProductToStock(StockDTO stockDTO);
    Stock getStockByProductId(Long productId);
    void deleteStockByProductId(Long productId);
    Stock updateStockQuantity(Long productId, int newQuantity);
}
