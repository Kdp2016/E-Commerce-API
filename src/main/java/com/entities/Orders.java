package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
    private int id;
    private Users buyer;
    private List<Products> products;
    private Status status;
    private float total;

    public Orders() {
    }

    public Orders(Users buyer, List<Products> products, Status status, float total) {
        this.buyer = buyer;
        this.products = products;
        this.status = status;
        this.total = total;
    }

    public Orders(int id, Users buyer, List<Products> products, Status status, float total) {
        this.id = id;
        this.buyer = buyer;
        this.products = products;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        return id == orders.id && Float.compare(orders.total, total) == 0 && Objects.equals(buyer, orders.buyer) && Objects.equals(products, orders.products) && Objects.equals(status, orders.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyer, products, status, total);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", products=" + products +
                ", status=" + status +
                ", total=" + total +
                '}';
    }

    public enum Status {
        ORDERED, DELIVERED, CANCELLED;
    }
}

