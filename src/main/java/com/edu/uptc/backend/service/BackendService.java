package com.edu.uptc.backend.service;

import com.edu.uptc.backend.dao.CustomerDao;
import com.edu.uptc.backend.dao.OrderDao;
import com.edu.uptc.backend.dao.ProductDao;
import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.dto.OrderCreationDTO;
import com.edu.uptc.backend.dto.OrderResponseDTO;
import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.entity.Order;
import com.edu.uptc.backend.entity.Product;
import com.edu.uptc.backend.mapper.CustomerMapper;
import com.edu.uptc.backend.mapper.OrderMapper;
import com.edu.uptc.backend.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackendService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;

    public List<CustomerDTO> fetchAllCustomers() {
        return customerDao.findAll().stream()
                .map(CustomerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> fetchAllProducts() {
        List<Product> productList = productDao.findAll();
        return ProductMapper.toProductDtoList(productList);
    }

    public List<OrderResponseDTO> fetchAllOrders() {
        return orderDao.findAll().stream()
                .map(OrderMapper::toOrderResponseDTO)
                .collect(Collectors.toList());
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

    public OrderResponseDTO addOrderInDB(OrderCreationDTO orderCreationDTO) {
        Order order = OrderMapper.toOrder(orderCreationDTO);
        //La fecha la crea la entidad
        order.setTotal(calculateTotal(orderCreationDTO.getProductIds()));
        order.setCustomer(customerDao.findById(orderCreationDTO.getCustomerId()));
        order.setProducts(getProductsByIds(orderCreationDTO.getProductIds()));
        Order savedOrder = orderDao.save(order);
        return OrderMapper.toOrderResponseDTO(savedOrder);
    }

    private Double calculateTotal(List<Long> productIds) {
        double total = 0.0;
        for (Long productId : productIds) {
            Product product = productDao.findById(productId);
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    private List<Product> getProductsByIds(List<Long> productIds) {
        List<Product> products = new ArrayList<>();
        for (Long productId : productIds) {
            Product product = productDao.findById(productId);
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }

}
