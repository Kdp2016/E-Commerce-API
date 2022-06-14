package com.models;

import java.util.Objects;

public class Orders {
    private int id;
    private int userId;
    private int productId;
    private String address;
    private int orderStatusId;
    private float total;

    public Orders() {
    }

    public Orders(int id, int userId, int productId, String address, int orderStatusId, float total) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.address = address;
        this.orderStatusId = orderStatusId;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && userId == orders.userId && productId == orders.productId && orderStatusId == orders.orderStatusId && Float.compare(orders.total, total) == 0 && Objects.equals(address, orders.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, address, orderStatusId, total);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", address='" + address + '\'' +
                ", orderStatusId=" + orderStatusId +
                ", total=" + total +
                '}';
    }
}

