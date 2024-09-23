package com.edu.uptc.backend.mapper;

import com.edu.uptc.backend.dto.OrderResponseDTO;
import com.edu.uptc.backend.dto.OrderCreationDTO;
import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.entity.Customer;
import com.edu.uptc.backend.entity.Order;
import com.edu.uptc.backend.entity.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderResponseDTO toOrderResponseDTO(Order order) {
        if (order == null) {
            return null;
        }
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(order.getId());
        orderResponseDTO.setCreationDateTime(order.getCreationDate());
        orderResponseDTO.setCustomerName(order.getCustomer() != null ? order.getCustomer().getName() : null);
        orderResponseDTO.setTotal(order.getTotal());
        orderResponseDTO.setProductDTOS(ProductMapper.toProductDtoList(order.getProducts()));
        return orderResponseDTO;
    }

    public static OrderCreationDTO toOrderCreationDTO(Order order) {
        if (order == null) return null;
        OrderCreationDTO orderCreationDTO = new OrderCreationDTO();
        orderCreationDTO.setCustomerId(orderCreationDTO.getCustomerId());
        List<Long> ids = new ArrayList<>();
        for (Product product: order.getProducts()){
            ids.add(product.getId());
        }
        orderCreationDTO.setProductIds(ids);
        return orderCreationDTO;
    }

    public static Order toOrder(OrderCreationDTO orderCreationDTO) {
        if (orderCreationDTO == null) {
            return null;
        }
        Order order = new Order();

        Customer customer = new Customer();
        customer.setId(orderCreationDTO.getCustomerId());

        Product product = new Product();
        product.setId(orderCreationDTO.getCustomerId());

        return order;
    }
}
