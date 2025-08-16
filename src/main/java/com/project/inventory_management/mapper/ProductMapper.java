package com.project.inventory_management.mapper;

import com.project.inventory_management.dto.AddProductDTORequest;
import com.project.inventory_management.dto.AddProductResponseDTO;
import com.project.inventory_management.model.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper implements Function<Product, AddProductResponseDTO> {

    @Override
    public AddProductResponseDTO apply(Product product) {
        return new AddProductResponseDTO(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getDescription()
        );
    }

    public Product requestToProduct(AddProductDTORequest addProductDTORequest){
         return Product.builder()
                 .productName(addProductDTORequest.productName())
                 .price(addProductDTORequest.price())
                 .description(addProductDTORequest.description())
                 .build();

    }

}
