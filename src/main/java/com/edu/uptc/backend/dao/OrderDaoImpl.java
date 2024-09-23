package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("FROM Order", Order.class).getResultList();
    }

    @Override
    public void save(Order order) {
        if (order.getId() == null) entityManager.persist(order);
        else entityManager.merge(order);
    }

    @Override
    public void delete(Long id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) entityManager.remove(order);
    }
}
