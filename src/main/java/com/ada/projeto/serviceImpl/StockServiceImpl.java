package com.ada.projeto.serviceImpl;

import com.ada.projeto.dto.StockDTO;
import com.ada.projeto.model.Product;
import com.ada.projeto.model.Stock;
import com.ada.projeto.repository.StockRepository;
import com.ada.projeto.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ProductServiceImpl productService;

    public StockServiceImpl(StockRepository stockRepository, ProductServiceImpl productService) {
        this.stockRepository = stockRepository;
        this.productService = productService;
    }

    @Override
    @Transactional
    public Stock addProductToStock(StockDTO stockDTO) {
        Stock stock = new Stock();

        Long productId = stockDTO.getProductId();
        Product product = productService.getProductById(productId);

        if (product != null) {
            stock.setProduct(product);
            stock.setQuantity(stockDTO.getQuantity());
            stock.setEntryDate(LocalDate.now());
            stock.setExitDate(LocalDate.now());
            return stockRepository.save(stock);
        } else {
            throw new RuntimeException("Produto com ID " + productId + " não encontrado");
        }
    }

    @Override
    public Stock getStockByProductId(Long productId) {
        return stockRepository.findByProduct_Id(productId);
    }

    @Override
    @Transactional
    public void deleteStockByProductId(Long productId) {
        stockRepository.deleteByProduct_Id(productId);
    }

    @Override
    @Transactional
    public Stock updateStockQuantity(Long productId, int newQuantity) {
        Stock stock = stockRepository.findByProduct_Id(productId);

        if (stock != null) {
            stock.setQuantity(newQuantity);
            return stockRepository.save(stock);
        } else {
            throw new RuntimeException("Produto com ID " + productId + " não encontrado no estoque");
        }
    }
}
