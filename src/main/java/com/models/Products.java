package com.models;

import java.util.Objects;

public class Products {
    private int id;
    private String productName;
    private String productDescription;
    private String productImage;
    private String brand;
    private float price;
    private int sellerId;
    private int categoryId;

    public Products() {
    }

    public Products(int id, String productName, String productDescription, String productImage, String brand, float price, int sellerId, int categoryId) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.brand = brand;
        this.price = price;
        this.sellerId = sellerId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && Float.compare(products.price, price) == 0 && sellerId == products.sellerId && categoryId == products.categoryId && Objects.equals(productName, products.productName) && Objects.equals(productDescription, products.productDescription) && Objects.equals(productImage, products.productImage) && Objects.equals(brand, products.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDescription, productImage, brand, price, sellerId, categoryId);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", sellerId=" + sellerId +
                ", categoryId=" + categoryId +
                '}';
    }
}
