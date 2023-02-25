package com.vti.rw41.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDTO {
    private String productName;
    private Double price;
    private String categoryName;
}
