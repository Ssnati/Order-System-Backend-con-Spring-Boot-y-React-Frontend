package com.edu.uptc.backend.mapper;

import com.edu.uptc.backend.dto.OrderResponseDTO;
import com.edu.uptc.backend.dto.OrderCreationDTO;
import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.entity.Customer;
import com.edu.uptc.backend.entity.Order;
import com.edu.uptc.backend.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderResponseDTO toOrderResponseDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getId());
        dto.setCustomerName(order.getCustomer() != null ? order.getCustomer().getName() : null);
        dto.setTotal(order.getTotal());

        // Asegurarte de que los productos están inicializados
        List<ProductDTO> productDTOs = new ArrayList<>();
        if (order.getProducts() != null) {
            productDTOs = order.getProducts().stream()
                    .map(product -> {
                        ProductDTO productDTO = new ProductDTO();
                        productDTO.setProductId(product.getId());
                        productDTO.setProductName(product.getName());
                        productDTO.setPrice(product.getPrice());
                        return productDTO;
                    })
                    .collect(Collectors.toList());
        }

        dto.setProductDTOS(productDTOs);
        return dto;
    }


    public static Order toOrder(OrderCreationDTO dto) {
        if (dto == null) {
            return null;
        }

        Order order = new Order();
        // Suponiendo que tienes un método para convertir CustomerDTO a Customer
        Customer customer = new Customer();
        customer.setName(dto.getCustomerDTO().getCustomerName()); // Otras propiedades si las tienes
        customer.setEmail(dto.getCustomerDTO().getCustomerEmail());

        order.setCustomer(customer);

        // Convertir ProductDTO a Product
        List<Product> products = dto.getProductDTOS().stream()
                .map(productDTO -> {
                    Product product = new Product();
                    product.setId(productDTO.getProductId());
                    product.setName(productDTO.getProductName());
                    product.setPrice(productDTO.getPrice());
                    return product;
                })
                .collect(Collectors.toList());

        order.setProducts(products);
        order.setCreationDate(dto.getCreationDate());
        order.setTotal(dto.getTotal());

        return order;
    }
}
