package com.ada.projeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")  // Nome da coluna que é uma chave estrangeira para o Product
    private Product product;
    private int quantity;
    private LocalDate entryDate;
    private LocalDate exitDate;

}
