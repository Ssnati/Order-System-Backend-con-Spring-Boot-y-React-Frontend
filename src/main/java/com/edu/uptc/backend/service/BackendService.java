package com.edu.uptc.backend.service;

import com.edu.uptc.backend.dao.*;
import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.entity.Customer;
import com.edu.uptc.backend.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackendService {

    @Autowired
    CustomerDao customerDao;
    ProductDao productDao = new ProductDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();

    public List<CustomerDTO> fetchAllCustomers() {
        List<Customer> customerList = customerDao.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDTO customerDTO = CustomerMapper.toCustomerDto(customer);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
