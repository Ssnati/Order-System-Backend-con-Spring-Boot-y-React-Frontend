package com.edu.uptc.backend.dao;

import com.edu.uptc.backend.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }
}
