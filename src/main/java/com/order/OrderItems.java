package com.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.Products;
import com.product.dtos.ProductResponse;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderItems")
public class OrderItems {
    @EmbeddedId
    private OrderItemsPK pk;

    @Column(nullable = false)
    private int quantity;

    public OrderItems() {
        super();
    }

    public OrderItems(int orderId, int productId, int quantity) {
        this.pk = new OrderItemsPK(orderId, productId);
        this.quantity = quantity;
    }

    public OrderItems(OrderItemsPK pk, int quantity) {
        this.pk = pk;
        this.quantity = quantity;
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
                "orderId=" + pk.getOrder().getId() +
                ", productId=" + pk.getProduct().getId() +
                ", quantity=" + quantity +
                '}';
    }
}
