package com.edu.uptc.backend.service;

import com.edu.uptc.backend.dao.CustomerDao;
import com.edu.uptc.backend.dao.OrderDao;
import com.edu.uptc.backend.dao.ProductDao;
import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.dto.OrderCreationDTO;
import com.edu.uptc.backend.dto.OrderResponseDTO;
import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.entity.Customer;
import com.edu.uptc.backend.entity.Order;
import com.edu.uptc.backend.entity.Product;
import com.edu.uptc.backend.mapper.CustomerMapper;
import com.edu.uptc.backend.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackendService {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    OrderDao orderDao;

    public List<CustomerDTO> fetchAllCustomers() {
        List<Customer> customerList = customerDao.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDTO customerDTO = CustomerMapper.toCustomerDto(customer);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    public List<OrderResponseDTO> fetchAllOrders() {
        List<Order> orderList = orderDao.findAll();
        List<OrderResponseDTO> orderResponseDTOS = new ArrayList<>();
        for (Order order : orderList) {
            OrderResponseDTO orderResponseDTO = OrderMapper.toOrderResponseDTO(order);
            orderResponseDTOS.add(orderResponseDTO);
        }
        return orderResponseDTOS;
    }

    public OrderResponseDTO addOrderInDB(OrderCreationDTO orderCreationDTO) {
        Order order = OrderMapper.toOrder(orderCreationDTO);
        if (orderCreationDTO.getCustomerDTO() != null) {
            Customer customer = new Customer();
            customer.setId(orderCreationDTO.getCustomerDTO().getCustomerId());
            // Otros atributos del cliente se pueden establecer aquí
            order.setCustomer(customer);
        }

        // Guarda la orden en la base de datos
        orderDao.save(order);

        return OrderMapper.toOrderResponseDTO(order);
    }

    public ResponseEntity<OrderResponseDTO> deleteOrderFromDBById(Long id) {
        Order order = orderDao.findById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        OrderResponseDTO orderResponseDTO = OrderMapper.toOrderResponseDTO(order);
        orderDao.delete(id);
        return ResponseEntity.ok(orderResponseDTO);
    }

    public List<ProductDTO> fetchAllProducts() {
        List<Product> productList = productDao.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(product.getId());
            productDTO.setProductName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
}
