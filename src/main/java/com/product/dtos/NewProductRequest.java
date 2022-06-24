package com.product.dtos;

import com.product.Products;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NewProductRequest {
    @NotNull
    private String productName;
    @NotNull
    private String productDescription;
    @NotNull
    private String productImage;
    @NotNull
    private String brand;
    @NotNull
    private double price;
    @NotNull
    private Users seller;
    @NotNull
    private Products.Categories category;

    public Products extractResource() {
        return new Products(productName, productDescription, productImage, brand, price, seller, category);
    }

    @Override
    public String toString() {
        return "NewProductRequest{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                ", category=" + category +
                '}';
    }
}
