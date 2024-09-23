package com.edu.uptc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailedDTO {
    private Long orderId;
    private String customerName;
    private List<ProductDetailedDTO> productDetailedDTOS;
    private Double total;
}
