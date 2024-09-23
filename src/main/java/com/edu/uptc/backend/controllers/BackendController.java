package com.edu.uptc.backend.controllers;

import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.dto.OrderCreationDTO;
import com.edu.uptc.backend.dto.OrderResponseDTO;
import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class BackendController {

    @Autowired
    BackendService backendService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> allOrders = backendService.fetchAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDTO> saveOrder(@RequestBody OrderCreationDTO orderCreationDTO) {
        OrderResponseDTO orderAdded = backendService.addOrderInDB(orderCreationDTO);
        return new ResponseEntity<>(orderAdded, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDTO> deleteOrderById(@PathVariable Long id) {
        return backendService.deleteOrderFromDBById(id);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> allCustomers = backendService.fetchAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts = backendService.fetchAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }


}
