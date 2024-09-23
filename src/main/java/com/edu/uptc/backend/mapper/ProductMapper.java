package com.edu.uptc.backend.mapper;

import com.edu.uptc.backend.dto.ProductDTO;
import com.edu.uptc.backend.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    // Convertir de Product a ProductDTO
    public static ProductDTO toProductDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId());
        productDTO.setProductName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    // Convertir de ProductDTO a Product
    public static Product toProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getProductId());
        product.setName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    // Convertir lista de Product a lista de ProductDTO
    public static List<ProductDTO> toProductDtoList(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(toProductDto(product));
        }
        return productDTOS;
    }

    // Convertir lista de ProductDTO a lista de Product
    public static List<Product> toProductList(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            products.add(toProduct(productDTO));
        }
        return products;
    }
}
