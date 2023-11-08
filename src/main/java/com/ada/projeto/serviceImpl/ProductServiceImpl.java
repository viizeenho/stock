package com.ada.projeto.serviceImpl;

import com.ada.projeto.model.Product;
import com.ada.projeto.repository.ProductRepository;
import com.ada.projeto.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
