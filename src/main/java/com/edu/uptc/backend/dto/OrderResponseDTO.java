package com.edu.uptc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long orderId;
    private LocalDateTime creationDateTime;
    private String customerName;
    private Double total;
    private List<ProductDTO> productDTOS;
}
