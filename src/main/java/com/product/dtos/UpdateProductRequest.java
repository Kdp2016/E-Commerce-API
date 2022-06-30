package com.product.dtos;

import com.product.Products;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdateProductRequest {

    @NotNull
    private int id;

    private String brand;

    private Products.Categories category;

    private double price;

    private String productDescription;

    private String productImage;

    private String productName;

    public Products extractResource() {

        return new Products(id, brand, productDescription, productImage, productName, category, price);
    }

    @Override
    public String toString() {
        return "UpdateProductRequest{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
