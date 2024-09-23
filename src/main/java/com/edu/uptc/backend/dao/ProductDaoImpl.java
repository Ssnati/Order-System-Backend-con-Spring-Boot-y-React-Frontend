package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("FROM Product", Product.class).getResultList();
    }
}
