package com.edu.uptc.backend.mapper;

import com.edu.uptc.backend.dto.CustomerDTO;
import com.edu.uptc.backend.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;


public class CustomerMapper {

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerEmail(),
                new ArrayList<>()
        );
    }

    public static CustomerDTO toCustomerDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}
