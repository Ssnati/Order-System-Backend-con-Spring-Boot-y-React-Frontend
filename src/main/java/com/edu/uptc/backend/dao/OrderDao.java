package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    Order findById(Long id);

    List<Order> findAll();

    void save(Order order);

    void delete(Long id);
}
