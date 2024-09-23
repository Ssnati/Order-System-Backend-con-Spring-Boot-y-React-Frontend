package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    List<Customer> findAll();

    Customer findById(Long id);
}
