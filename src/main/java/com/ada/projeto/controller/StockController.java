package com.ada.projeto.controller;

import com.ada.projeto.dto.StockDTO;
import com.ada.projeto.model.Stock;
import com.ada.projeto.serviceImpl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockServiceImpl stockServiceImpl;

    @Autowired
    public StockController(StockServiceImpl stockServiceImpl) {
        this.stockServiceImpl = stockServiceImpl;
    }

    @PostMapping("/addProduct")
    public Stock addProductToStock(@RequestBody StockDTO stockDTO){
        return stockServiceImpl.addProductToStock(stockDTO);
    }

    @GetMapping("/{productId}")
    public Stock getStockByProductId(@PathVariable Long productId) {
        return stockServiceImpl.getStockByProductId(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteStockByProductId(@PathVariable Long productId) {
        stockServiceImpl.deleteStockByProductId(productId);
    }

    @PutMapping("/{productId}")
    public Stock updateStockQuantity(@PathVariable Long productId, @RequestParam int newQuantity) {
        return stockServiceImpl.updateStockQuantity(productId, newQuantity);
    }

}
