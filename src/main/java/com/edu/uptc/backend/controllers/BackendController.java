package com.edu.uptc.backend.controllers;

import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class BackendController {

    @Autowired
    BackendService backendService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> allCustomers = backendService.fetchAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

}
