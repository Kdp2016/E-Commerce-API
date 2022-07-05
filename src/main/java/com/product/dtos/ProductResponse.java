package com.product.dtos;

import com.product.Products;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String productName;
    private String productDescription;
    private String productImage;
    private String brand;
    private double price;
    private int sellerId;
    private Products.Categories category;
    private boolean isActive;

    public ProductResponse(Products product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productDescription = product.getProductDescription();
        this.productImage = product.getProductImage();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.sellerId = product.getSeller().getId();
        this.category = product.getCategory();
        this.isActive = product.isActive();
    }
}
