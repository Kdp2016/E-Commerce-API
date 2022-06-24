package com.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.Products;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderItems")
public class OrderItems {
    @EmbeddedId
    @JsonIgnore
    private OrderItemsPK pk;

    @Column(nullable = false)
    private int quantity;

    public OrderItems(OrderItemsPK pk, int quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public OrderItems(Orders order, Products product, int quantity) {
        pk = new OrderItemsPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Products getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderItemsPK getPk() {
        return pk;
    }

    public void setPk(OrderItemsPK pk) {
        this.pk = pk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems orderItem = (OrderItems) o;
        return quantity == orderItem.quantity && Objects.equals(pk, orderItem.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "pk=" + pk +
                ", quantity=" + quantity +
                '}';
    }
}
