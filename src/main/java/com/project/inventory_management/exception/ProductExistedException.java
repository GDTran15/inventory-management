package com.project.inventory_management.exception;

public class ProductExistedException extends RuntimeException {

    public ProductExistedException(){
        super("Product has existed");
    }

}
