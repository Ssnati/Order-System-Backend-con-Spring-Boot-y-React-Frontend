package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    List<Product> findAll();
}
