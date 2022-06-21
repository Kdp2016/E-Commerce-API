package com.entities;

import java.util.Objects;

public class Products {
    private int id;
    private String productName;
    private String productDescription;
    private String productImage;
    private String brand;
    private double price;
    private Users seller;
    private Categories category;

    public Products() {
    }

    public Products(int id, String productName, String productDescription, String productImage, String brand, double price, Users seller, Categories category) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.brand = brand;
        this.price = price;
        this.seller = seller;
        this.category = category;
    }

    public Products(String productName, String productDescription, String productImage, String brand, double price, Users seller, Categories category) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.brand = brand;
        this.price = price;
        this.seller = seller;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && Double.compare(products.price, price) == 0 && Objects.equals(productName, products.productName) && Objects.equals(productDescription, products.productDescription) && Objects.equals(productImage, products.productImage) && Objects.equals(brand, products.brand) && Objects.equals(seller, products.seller) && Objects.equals(category, products.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDescription, productImage, brand, price, seller, category);
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
                ", seller=" + seller +
                ", category=" + category +
                '}';
    }
}
