package com.edu.uptc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreationDTO {
    private List<ProductDTO> productDTOS;
    private LocalDateTime creationDate;
    private Double total;
    private CustomerDTO customerDTO;
}
