package com.edu.uptc.backend.mapper;

import com.edu.uptc.backend.dto.OrderDetailedDTO;
import com.edu.uptc.backend.dto.OrderProductCustomerDTO;
import com.edu.uptc.backend.dto.ProductDetailedDTO;
import com.edu.uptc.backend.entity.Customer;
import com.edu.uptc.backend.entity.Order;
import com.edu.uptc.backend.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDetailedDTO toOrderDetailedDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDetailedDTO dto = new OrderDetailedDTO();
        dto.setOrderId(order.getId());
        dto.setCustomerName(order.getCustomer().getName());
        dto.setTotal(order.getTotal());

        List<ProductDetailedDTO> productDTOs = order.getProducts().stream()
                .map(product -> {
                    ProductDetailedDTO productDTO = new ProductDetailedDTO();
                    productDTO.setProductId(product.getId());
                    productDTO.setProductName(product.getName());
                    productDTO.setPrice(product.getPrice());
                    return productDTO;
                })
                .collect(Collectors.toList());

        dto.setProductDetailedDTOS(productDTOs);
        return dto;
    }

    public static Order toOrder(OrderProductCustomerDTO dto, Customer customer, List<Product> products) {
        if (dto == null) {
            return null;
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(products);
        return order;
    }
}
