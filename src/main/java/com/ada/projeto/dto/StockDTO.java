package com.ada.projeto.dto;

import com.ada.projeto.model.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StockDTO {

    private Long productId;
    private int quantity;
    private LocalDate entryDate;
    private LocalDate exitDate;

}
